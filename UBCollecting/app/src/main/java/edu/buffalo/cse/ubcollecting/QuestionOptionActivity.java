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

    private EditText langField;
    private EditText optionTextField;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_option);

        langField = this.findViewById(R.id.question_option_lang_field);
        optionTextField = this.findViewById(R.id.question_option_text_field);
        submitButton = this.findViewById(R.id.question_option_submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionOption option = new QuestionOption();
                option.setQuestionId(0); // TODO
                option.setLanguageId(0); // TODO
                option.setOptionText(optionTextField.getText().toString());

                QuestionOptionTable.addQuestionOption(option);
            }
        });
    }
}
