package edu.buffalo.cse.ubcollecting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

import edu.buffalo.cse.ubcollecting.data.models.Questionnaire;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionnaireTable;

public class QuestionnaireActivity extends AppCompatActivity {

    private static final String TAG = QuestionnaireActivity.class.getSimpleName().toString();

    private TextView idField;
    private EditText nameField;
    private EditText labelField;
    private EditText descriptionField;
    private EditText typeField;
    private Button submitButton;

    private QuestionnaireTable questionnaireTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        idField = this.findViewById(R.id.questionnaire_id_field);
        idField.setText(UUID.randomUUID().toString());
        nameField = this.findViewById(R.id.questionnaire_name_field);
        labelField = this.findViewById(R.id.questionnaire_label_field);
        descriptionField = this.findViewById(R.id.questionnaire_description_field);
        typeField = this.findViewById(R.id.questionnaire_type_field);
        submitButton = this.findViewById(R.id.questionnaire_submit_button);

        questionnaireTable = new QuestionnaireTable();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Questionnaire quiz = new Questionnaire();
                quiz.setId(idField.getText().toString());
                quiz.setLabel(labelField.getText().toString());
                quiz.setName(nameField.getText().toString());
                quiz.setDescription(descriptionField.getText().toString());
                quiz.setType(typeField.getText().toString());

                questionnaireTable.addQuestionnaire(quiz);
            }
        });
    }
}
