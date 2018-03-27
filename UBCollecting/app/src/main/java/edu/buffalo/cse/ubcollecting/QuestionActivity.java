package edu.buffalo.cse.ubcollecting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.buffalo.cse.ubcollecting.data.models.Question;

import static edu.buffalo.cse.ubcollecting.data.DatabaseHelper.QUESTION_TABLE;

public class QuestionActivity extends AppCompatActivity {

    private static final String TAG = QuestionActivity.class.getSimpleName().toString();

    private EditText questionTypeField;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        questionTypeField = this.findViewById(R.id.question_type_field);
        submitButton = this.findViewById(R.id.question_submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Question question = new Question();
                question.setType(questionTypeField.getText().toString());

                QUESTION_TABLE.insert(question);
            }
        });
    }
}
