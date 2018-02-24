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

    private TextView idField;
    private EditText nameField;
    private Button submitButton;

    private QuestionPropertyDefTable propertyDefTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_property_def);

        idField = this.findViewById(R.id.question_property_def_id_field);
        nameField = this.findViewById(R.id.question_property_def_name_field);
        submitButton = this.findViewById(R.id.question_property_def_submit_button);

        propertyDefTable = new QuestionPropertyDefTable();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                QuestionPropertyDef propertyDef = new QuestionPropertyDef();
                propertyDef.setId(idField.getText().toString());
                propertyDef.setName(nameField.getText().toString());

                propertyDefTable.addQuestionPropertyDef(propertyDef);
            }
        });
    }
}
