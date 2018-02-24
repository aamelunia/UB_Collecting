package edu.buffalo.cse.ubcollecting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

import edu.buffalo.cse.ubcollecting.data.models.Answer;
import edu.buffalo.cse.ubcollecting.data.tables.AnswerTable;

public class AnswerActivity extends AppCompatActivity {

    private static final String TAG = AnswerActivity.class.getSimpleName().toString();

    private TextView idField;
    private EditText questionnaireIdField;
    private EditText questionIdField;
    private EditText answerLabelField;
    private EditText answerTextField;
    private Button submitButton;

    private AnswerTable answerTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_answer);

        idField = this.findViewById(R.id.answer_id_field);
        idField.setText(UUID.randomUUID().toString());
        questionnaireIdField = this.findViewById(R.id.answer_questionnaire_id_field);
        questionIdField = this.findViewById(R.id.answer_question_id_field);
        answerLabelField = this.findViewById(R.id.answer_label_field);
        answerTextField = this.findViewById(R.id.answer_text_field);
        submitButton = this.findViewById(R.id.answer_submit_button);

        answerTable = new AnswerTable();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Answer answer = new Answer();
                answer.setId(idField.getText().toString());
                answer.setQuestionnaireId(questionnaireIdField.getText().toString());
                answer.setQuestionId(questionIdField.getText().toString());
                answer.setLabel(answerLabelField.getText().toString());
                answer.setText(answerTextField.getText().toString());

                answerTable.addAnswer(answer);
            }
        });
    }
}
