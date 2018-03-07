package edu.buffalo.cse.ubcollecting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.buffalo.cse.ubcollecting.data.models.QuestionnaireType;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionnaireTypeTable;

public class QuestionnaireTypeActivity extends AppCompatActivity {

    private static final String TAG = QuestionnaireTypeActivity.class.getSimpleName().toString();

    private EditText nameField;
    private Button submitButton;

    private QuestionnaireTypeTable questionnaireTypeTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_type);

        nameField = this.findViewById(R.id.questionnaire_type_name_field);
        submitButton = this.findViewById(R.id.questionnaire_type_submit_button);

        questionnaireTypeTable = new QuestionnaireTypeTable();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionnaireType questionnaireType = new QuestionnaireType();
                questionnaireType.setName(nameField.getText().toString());

                int id = questionnaireTypeTable.addQuestionnaireType(questionnaireType);
                questionnaireType.setId(id);
            }
        });
    }
}
