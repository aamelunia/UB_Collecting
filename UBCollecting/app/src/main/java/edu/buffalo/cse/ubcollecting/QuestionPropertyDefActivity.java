package edu.buffalo.cse.ubcollecting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.buffalo.cse.ubcollecting.data.models.QuestionPropertyDef;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionPropertyDefTable;

public class QuestionPropertyDefActivity extends AppCompatActivity {

    private static final String TAG = QuestionPropertyDefActivity.class.getSimpleName().toString();

    private EditText nameField;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_property_def);

        nameField = this.findViewById(R.id.question_property_def_name_field);
        submitButton = this.findViewById(R.id.question_property_def_submit_button);


        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionPropertyDef propertyDef = new QuestionPropertyDef();
                propertyDef.setName(nameField.getText().toString());

                int id = QuestionPropertyDefTable.addQuestionPropertyDef(propertyDef);

                propertyDef.setId(id);
            }
        });
    }
}
