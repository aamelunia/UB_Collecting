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

    private TextView langIdField;
    private EditText questionIdField;
    private EditText questionTextField;
    private Button submitButton;

    private QuestionLangVersionTable questionLangVersionTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_lang_version);

        langIdField = this.findViewById(R.id.question_lang_version_id_field);
        questionIdField = this.findViewById(R.id.question_lang_question_id_field);
        questionTextField = this.findViewById(R.id.question_lang_version_text_field);
        submitButton = this.findViewById(R.id.question_lang_version_submit_button);

        questionLangVersionTable = new QuestionLangVersionTable();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionLangVersion questionLangVersion = new QuestionLangVersion();
                questionLangVersion.setLanguageId(langIdField.getText().toString());
                questionLangVersion.setQuestionId(questionIdField.getText().toString());
                questionLangVersion.setQuestionText(questionTextField.getText().toString());

                questionLangVersionTable.addQuestionLangVersion(questionLangVersion);
            }
        });
    }
}
