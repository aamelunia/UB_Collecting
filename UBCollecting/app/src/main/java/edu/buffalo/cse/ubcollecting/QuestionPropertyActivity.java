package edu.buffalo.cse.ubcollecting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.buffalo.cse.ubcollecting.data.models.QuestionProperty;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionPropertyTable;

public class QuestionPropertyActivity extends AppCompatActivity {

    private static final String TAG = QuestionProperty.class.getSimpleName().toString();

    private TextView idField;
    private EditText questionIdField;
    private EditText valueField;
    private Button submitButton;

    private QuestionPropertyTable questionPropertyTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_property);

        idField = this.findViewById(R.id.question_property_id_field);
        questionIdField = this.findViewById(R.id.question_property_qid_field);
        valueField = this.findViewById(R.id.question_property_value_field);
        submitButton = this.findViewById(R.id.question_property_submit_button);

        questionPropertyTable = new QuestionPropertyTable();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionProperty property = new QuestionProperty();
                property.setPropertyId(idField.getText().toString());
                property.setQuestionId(questionIdField.getText().toString());
                property.setValue(0);

                questionPropertyTable.addQuestionProperty(property);
            }
        });
    }
}
