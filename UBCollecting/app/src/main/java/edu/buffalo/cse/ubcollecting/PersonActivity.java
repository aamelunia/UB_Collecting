package edu.buffalo.cse.ubcollecting;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import edu.buffalo.cse.ubcollecting.data.models.Person;

import static edu.buffalo.cse.ubcollecting.data.DatabaseHelper.PERSON_TABLE;

public class PersonActivity extends AppCompatActivity {

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

    private String roleId;
    private ArrayAdapter<String> roleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person);
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

        nameField = this.findViewById(R.id.person_name_field);
        preferredNameField = this.findViewById(R.id.person_preferred_name_field);
        dobField = this.findViewById(R.id.person_dob_field);
        roleSpinner = this.findViewById(R.id.person_role_spinner);
        List<String> roles = new ArrayList<>();
        roles.add("");
        roles.add("Create New Role");

        roleAdapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, roles);
        roleSpinner.setAdapter(roleAdapter);
        roleSpinner.setSelected(false);
        roleSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String item = parent.getItemAtPosition(position).toString();

                if (position == roleAdapter.getCount() - 1) {
                    Intent i = RoleActivity.newIntent(PersonActivity.this);
                    startActivityForResult(i, REQUEST_CODE_ROLE);
                }
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
                applicant.setName(nameField.getText().toString());
                applicant.setOtherNames(preferredNameField.getText().toString());
                applicant.setDob(dobField.getText().toString());
                applicant.setPhoto(photoField.getText().toString());
                applicant.setPhotoDesc(photoDescriptionField.getText().toString());
                applicant.setMainRoleId(roleId); // TODO
                applicant.setIntroQuestDesc(questionnaireDescriptionField.getText().toString());

                PERSON_TABLE.insert(applicant);

                Toast.makeText(PersonActivity.this,
                        "Added " + applicant.getName() + " to database",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == REQUEST_CODE_ROLE) {
            roleId = RoleActivity.getId(data);
            roleAdapter.insert(RoleActivity.getName(data), 0);
            roleSpinner.setAdapter(roleAdapter);
        }
    }

}
