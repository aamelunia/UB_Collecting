package edu.buffalo.cse.ubcollecting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.buffalo.cse.ubcollecting.data.models.QuestionLangVersion;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionLangVersionTable;

public class QuestionLangVersionActivity extends AppCompatActivity {

    private static final String TAG = QuestionLangVersionActivity.class.getSimpleName().toString();

    private TextView questionField;
    private EditText langField;
    private EditText questionTextField;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_lang_version);

        questionField = this.findViewById(R.id.question_lang_version_question_field);
        langField = this.findViewById(R.id.question_lang_field);
        questionTextField = this.findViewById(R.id.question_lang_version_text_field);
        submitButton = this.findViewById(R.id.question_lang_version_submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionLangVersion questionLangVersion = new QuestionLangVersion();
                questionLangVersion.setQuestionLanguageId(0); // TODO
                questionLangVersion.setQuestionId(0); // TODO
                questionLangVersion.setQuestionText(questionTextField.getText().toString());

                QuestionLangVersionTable.addQuestionLangVersion(questionLangVersion);
            }
        });
    }
}
