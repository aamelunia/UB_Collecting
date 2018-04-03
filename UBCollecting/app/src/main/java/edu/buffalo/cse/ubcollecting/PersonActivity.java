package edu.buffalo.cse.ubcollecting;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.List;

import edu.buffalo.cse.ubcollecting.data.DatabaseHelper;
import edu.buffalo.cse.ubcollecting.data.models.Person;
import edu.buffalo.cse.ubcollecting.data.models.Role;
import edu.buffalo.cse.ubcollecting.data.tables.Table;

import static edu.buffalo.cse.ubcollecting.data.DatabaseHelper.PERSON_TABLE;
import static edu.buffalo.cse.ubcollecting.data.tables.Table.EXTRA_MODEL;

public class PersonActivity extends EntryActivity<Person> {

    private static final String TAG = PersonActivity.class.getSimpleName().toString();
    private static final int REQUEST_CODE_ROLE = 0;
    private static final int REQUEST_IMAGE_CAPTURE = 1;


    private EditText nameField;
    private EditText preferredNameField;
    private EditText dobField;
    private Spinner roleSpinner;
    private ImageView photoView;
    private Button photoButton;
    private EditText photoDescriptionField;
    private EditText questionnaireDescriptionField;
    private Button updateButton;
    private Button submitButton;

    private ArrayAdapter<Role> roleAdapter;

    @Override
    public void setUI(Person entry) {
        nameField.setText(entry.getName());
        preferredNameField.setText(entry.getOtherNames());
        dobField.setText(entry.getDob());
        retrieveImage();
        photoDescriptionField.setText(entry.getPhotoDesc());
        questionnaireDescriptionField.setText(entry.getIntroQuestDesc());
    }

    @Override
    public void setEntryByUI() {
        Role role = (Role) roleSpinner.getSelectedItem();

        entry.setName(nameField.getText().toString());
        entry.setOtherNames(preferredNameField.getText().toString());
        entry.setDob(dobField.getText().toString());
        addImage();
        entry.setPhotoDesc(photoDescriptionField.getText().toString());
        entry.setMainRoleId(role.getId());
        entry.setIntroQuestDesc(questionnaireDescriptionField.getText().toString());
    }

    @Override
    public void handleResultGet(int requestCode, Intent data) {
        Serializable serializableObject = data.getSerializableExtra(EXTRA_MODEL);
        if (serializableObject instanceof Role) {
            Role role = (Role) serializableObject;
            roleAdapter.insert(role, 0);
            roleSpinner.setAdapter(roleAdapter);
        }
    }


    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


        nameField = this.findViewById(R.id.person_name_field);
        preferredNameField = this.findViewById(R.id.person_preferred_name_field);
        dobField = this.findViewById(R.id.person_dob_field);

        roleSpinner = this.findViewById(R.id.person_role_spinner);
        List<Role> roles = DatabaseHelper.ROLE_TABLE.getAll();

        roleAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, roles);
        roleSpinner.setAdapter(roleAdapter);
        roleSpinner.setSelected(false);
        roleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                Role role = (Role) parent.getItemAtPosition(position);
                TextView listView = (TextView) view.findViewById(android.R.id.text1);
                listView.setText(role.getName());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        if ( ContextCompat.checkSelfPermission( this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED ) {
            ActivityCompat.requestPermissions( this, new String[] {  Manifest.permission.CAMERA  }, REQUEST_IMAGE_CAPTURE );
        }

        photoView = this.findViewById(R.id.person_photo_view);

        photoButton = this.findViewById(R.id.person_photo_button);

        photoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }
        });


        photoDescriptionField = this.findViewById(R.id.person_photo_description_field);
        questionnaireDescriptionField = this.findViewById(R.id.person_questionnaire_description_field);

        updateButton = this.findViewById(R.id.person_update_button);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEntryByUI();
                PERSON_TABLE.update(entry);
                setEntryUpdatedResult(entry);
                finish();
            }
        });

        submitButton = this.findViewById(R.id.person_submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setEntryByUI();
                PERSON_TABLE.insert(entry);
                setEntryCreatedResult(entry);
                finish();
            }
        });

        if (getIntent().getFlags() == Table.FLAG_EDIT_ENTRY) {
            entry = getEntry(getIntent());
            setUI(entry);
            updateButton.setVisibility(View.VISIBLE);
            submitButton.setVisibility(View.GONE);
        } else {
            entry = new Person();
        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_IMAGE_CAPTURE ) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            photoView.setImageBitmap(imageBitmap);
        }
    }

    private void addImage(){
        photoView.setDrawingCacheEnabled(true);
        photoView.buildDrawingCache();
        Bitmap bitmap = photoView.getDrawingCache();
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG,100,bo);
        byte[] data = bo.toByteArray();
        entry.setPhoto(data);
    }

    private void retrieveImage(){
        byte [] image = entry.getPhoto();
        Bitmap bitmap = BitmapFactory.decodeByteArray(image,0,image.length);
        photoView.setImageBitmap(bitmap);
    }

}
