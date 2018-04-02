package edu.buffalo.cse.ubcollecting;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.util.List;

import edu.buffalo.cse.ubcollecting.data.DatabaseHelper;
import edu.buffalo.cse.ubcollecting.data.models.Person;
import edu.buffalo.cse.ubcollecting.data.models.Role;

import static edu.buffalo.cse.ubcollecting.data.DatabaseHelper.PERSON_TABLE;

public class PersonActivity extends EntryActivity<Person> {

    private static final String TAG = PersonActivity.class.getSimpleName().toString();
    private static final int REQUEST_CODE_ROLE = 0;

    private EditText nameField;
    private EditText preferredNameField;
    private EditText dobField;
    private Spinner roleSpinner;
    private EditText photoField;
    private EditText photoDescriptionField;
    private EditText questionnaireDescriptionField;
    private Button submitButton;

    private ArrayAdapter<Role> roleAdapter;

    @Override
    public void setUI(Person entry) {
        nameField.setText(entry.getName());
        preferredNameField.setText(entry.getOtherNames());
        dobField.setText(entry.getDob());
        photoField.setText(entry.getPhoto());
        photoDescriptionField.setText(entry.getPhotoDesc());
        questionnaireDescriptionField.setText(entry.getIntroQuestDesc());
    }

    @Override
    public void handleResultGet(int requestCode, Intent data) {
        Serializable serializableObject = data.getSerializableExtra(EXTRA_MODEL);
        if (serializableObject instanceof Role) {
            Role role = (Role) serializableObject;
            entry.setMainRoleId(role.getId());
            roleAdapter.insert(role, 0);
            roleSpinner.setAdapter(roleAdapter);
        }
    }

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
                Log.i(TAG, view.toString());
                TextView listView = (TextView) view.findViewById(android.R.id.text1);
                listView.setText(role.getName());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        photoField = this.findViewById(R.id.person_photo_field);
        photoDescriptionField = this.findViewById(R.id.person_photo_description_field);
        questionnaireDescriptionField = this.findViewById(R.id.person_questionnaire_description_field);
        submitButton = this.findViewById(R.id.person_submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person applicant = new Person();
                Role role = (Role) roleSpinner.getSelectedItem();

                applicant.setName(nameField.getText().toString());
                applicant.setOtherNames(preferredNameField.getText().toString());
                applicant.setDob(dobField.getText().toString());
                applicant.setPhoto(photoField.getText().toString());
                applicant.setPhotoDesc(photoDescriptionField.getText().toString());
                applicant.setMainRoleId(role.getId());
                applicant.setIntroQuestDesc(questionnaireDescriptionField.getText().toString());

                PERSON_TABLE.insert(applicant);

                Toast.makeText(PersonActivity.this,
                        "Added " + applicant.getName() + " to database",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }
}
