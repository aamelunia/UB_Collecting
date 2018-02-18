package edu.buffalo.cse.ubcollecting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

import edu.buffalo.cse.ubcollecting.data.models.Person;
import edu.buffalo.cse.ubcollecting.data.tables.PersonTable;
import edu.buffalo.cse.ubcollecting.data.DatabaseHelper;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName().toString();

    private TextView idField;
    private EditText nameField;
    private EditText preferredNameField;
    private EditText dobField;
    private EditText roleField;
    private EditText photoField;
    private EditText photoDescriptionField;
    private EditText questionnaireDescriptionField;
    private Button submitButton;

    private PersonTable personTable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        idField = this.findViewById(R.id.id_field);
        idField.setText(UUID.randomUUID().toString());
        nameField = this.findViewById(R.id.name_field);
        preferredNameField = this.findViewById(R.id.preferred_name_field);
        dobField = this.findViewById(R.id.dob_field);
        roleField = this.findViewById(R.id.role_field);
        photoField = this.findViewById(R.id.photo_field);
        photoDescriptionField = this.findViewById(R.id.photo_description_field);
        questionnaireDescriptionField = this.findViewById(R.id.questionnakre_description_field);
        submitButton = this.findViewById(R.id.submit_button);

        personTable = new PersonTable();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person applicant = new Person();
                applicant.setId(idField.getText().toString());
                applicant.setName(nameField.getText().toString());
                applicant.setOtherNames(preferredNameField.getText().toString());
                applicant.setDob(dobField.getText().toString());
                applicant.setPhoto(photoField.getText().toString());
                applicant.setPhotoDesc(photoDescriptionField.getText().toString());
                applicant.setRole(roleField.getText().toString());
                applicant.setQuestDesc(questionnaireDescriptionField.getText().toString());

                personTable.addPerson(applicant);
                Toast.makeText(MainActivity.this,
                               "Added " + applicant.getName() + " to database",
                               Toast.LENGTH_SHORT).show();
            }
        });
    }
}
