package edu.buffalo.cse.ubcollecting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.buffalo.cse.ubcollecting.data.models.QuestionOption;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionOptionTable;

public class QuestionOptionActivity extends AppCompatActivity {

    private static final String TAG = QuestionOptionActivity.class.getSimpleName().toString();

    private TextView idField;
    private EditText langIdField;
    private EditText optionTextField;
    private Button submitButton;

    private QuestionOptionTable optionTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_option);

        idField = this.findViewById(R.id.question_option_id_field);
        langIdField = this.findViewById(R.id.question_option_lang_id_field);
        optionTextField = this.findViewById(R.id.question_option_text_field);
        submitButton = this.findViewById(R.id.question_option_submit_button);

        optionTable = new QuestionOptionTable();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionOption option = new QuestionOption();
                option.setQuestionId(idField.getText().toString());
                option.setLanguageId(langIdField.getText().toString());
                option.setOptionText(optionTextField.getText().toString());

                optionTable.addQuestionOption(option);
            }
        });
    }
}
