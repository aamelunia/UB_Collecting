package edu.buffalo.cse.ubcollecting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.buffalo.cse.ubcollecting.data.models.QuestionnaireType;

import static edu.buffalo.cse.ubcollecting.data.DatabaseHelper.QUESTIONNAIRE_TYPE_TABLE;

public class QuestionnaireTypeActivity extends AppCompatActivity {

    private static final String TAG = QuestionnaireTypeActivity.class.getSimpleName().toString();

    private EditText nameField;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_type);

        nameField = this.findViewById(R.id.questionnaire_type_name_field);
        submitButton = this.findViewById(R.id.questionnaire_type_submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionnaireType questionnaireType = new QuestionnaireType();
                questionnaireType.setName(nameField.getText().toString());

                QUESTIONNAIRE_TYPE_TABLE.insert(questionnaireType);
            }
        });
    }
}
