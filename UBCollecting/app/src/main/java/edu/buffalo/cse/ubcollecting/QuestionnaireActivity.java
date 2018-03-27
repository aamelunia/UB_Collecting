package edu.buffalo.cse.ubcollecting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.buffalo.cse.ubcollecting.data.models.Questionnaire;

import static edu.buffalo.cse.ubcollecting.data.DatabaseHelper.QUESTIONNAIRE_TABLE;

public class QuestionnaireActivity extends AppCompatActivity {

    private static final String TAG = QuestionnaireActivity.class.getSimpleName().toString();

    private EditText nameField;
    private EditText labelField;
    private EditText descriptionField;
    private EditText typeField;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        nameField = this.findViewById(R.id.questionnaire_name_field);
        labelField = this.findViewById(R.id.questionnaire_label_field);
        descriptionField = this.findViewById(R.id.questionnaire_description_field);
        typeField = this.findViewById(R.id.questionnaire_type_field);
        submitButton = this.findViewById(R.id.questionnaire_submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Questionnaire quiz = new Questionnaire();
                quiz.setLabel(labelField.getText().toString());
                quiz.setName(nameField.getText().toString());
                quiz.setDescription(descriptionField.getText().toString());
                quiz.setTypeId(""); // TODO

                QUESTIONNAIRE_TABLE.insert(quiz);
            }
        });
    }
}
