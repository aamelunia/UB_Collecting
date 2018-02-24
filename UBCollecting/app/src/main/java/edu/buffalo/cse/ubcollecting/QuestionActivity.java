package edu.buffalo.cse.ubcollecting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

import edu.buffalo.cse.ubcollecting.data.models.Question;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionTable;

public class QuestionActivity extends AppCompatActivity {

    private static final String TAG = QuestionActivity.class.getSimpleName().toString();

    private TextView idField;
    private EditText questionTypeField;
    private Button submitButton;

    private QuestionTable questionTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        idField = this.findViewById(R.id.question_id_field);
        idField.setText(UUID.randomUUID().toString());
        questionTypeField = this.findViewById(R.id.question_type_field);
        submitButton = this.findViewById(R.id.question_submit_button);

        questionTable = new QuestionTable();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Question question = new Question();
                question.setId(idField.getText().toString());
                question.setType(questionTypeField.getText().toString());

                questionTable.addQuestion(question);
            }
        });
    }
}
