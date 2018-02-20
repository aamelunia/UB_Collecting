package edu.buffalo.cse.ubcollecting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

import edu.buffalo.cse.ubcollecting.data.models.QuestionnaireContent;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionnaireContentTable;

public class QuestionnaireContentActivity extends AppCompatActivity {

    private static final String TAG = QuestionnaireContentActivity.class.getSimpleName().toString();

    private TextView idField;
    private EditText questionIdField;
    private EditText orderField;
    private Button submitButton;

    private QuestionnaireContentTable questionnaireContentTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire_content);

        idField = this.findViewById(R.id.questionnaire_content_id_field);
        idField.setText(UUID.randomUUID().toString());
        questionIdField = this.findViewById(R.id.questionnaire_content_question_id_field);
        orderField = this.findViewById(R.id.questionnaire_content_order_field);
        submitButton = this.findViewById(R.id.questionnaire_content_submit_button);

        questionnaireContentTable = new QuestionnaireContentTable();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionnaireContent content = new QuestionnaireContent();
                content.setQuestionnaireId(idField.getText().toString());
                content.setQuestionId(questionIdField.getText().toString());
                content.setQuestionOrder(orderField.getText().toString());

                questionnaireContentTable.addQuestionnaireContent(content);
            }
        });
    }
}
