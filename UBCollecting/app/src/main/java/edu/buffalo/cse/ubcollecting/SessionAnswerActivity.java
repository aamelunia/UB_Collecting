package edu.buffalo.cse.ubcollecting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.buffalo.cse.ubcollecting.data.models.Session;
import edu.buffalo.cse.ubcollecting.data.models.SessionAnswer;
import edu.buffalo.cse.ubcollecting.data.tables.SessionAnswerTable;

public class SessionAnswerActivity extends AppCompatActivity {

    private static final String TAG = SessionAnswerActivity.class.getSimpleName().toString();

    private TextView idField;
    private EditText questionnaireIdField;
    private EditText questionIdField;
    private EditText answerIdField;
    private Button submitButton;

    private SessionAnswerTable sessionAnswerTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_answer);

        idField = this.findViewById(R.id.session_answer_id_field);
        questionnaireIdField = this.findViewById(R.id.session_answer_questionnaire_id_field);
        questionIdField = this.findViewById(R.id.session_answer_question_id_field);
        answerIdField = this.findViewById(R.id.session_answer_answer_id_field);
        submitButton = this.findViewById(R.id.session_answer_submit_button);

        sessionAnswerTable = new SessionAnswerTable();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SessionAnswer sessionAnswer = new SessionAnswer();
                sessionAnswer.setSessionId(idField.getText().toString());
                sessionAnswer.setQuestionnaireId(questionnaireIdField.getText().toString());
                sessionAnswer.setQuestionId(questionIdField.getText().toString());
                sessionAnswer.setAnswerId(answerIdField.getText().toString());

                sessionAnswerTable.addSessionAnswer(sessionAnswer);
            }
        });
    }
}
