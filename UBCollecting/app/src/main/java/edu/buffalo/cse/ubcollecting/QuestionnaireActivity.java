package edu.buffalo.cse.ubcollecting;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import edu.buffalo.cse.ubcollecting.data.models.Questionnaire;
import edu.buffalo.cse.ubcollecting.data.models.QuestionnaireType;
import edu.buffalo.cse.ubcollecting.data.tables.Table;
import edu.buffalo.cse.ubcollecting.ui.AddQuestionsActivity;
import edu.buffalo.cse.ubcollecting.ui.EntryOnItemSelectedListener;

import static edu.buffalo.cse.ubcollecting.data.DatabaseHelper.QUESTIONNAIRE_TABLE;
import static edu.buffalo.cse.ubcollecting.data.DatabaseHelper.QUESTIONNAIRE_TYPE_TABLE;

public class QuestionnaireActivity extends EntryActivity<Questionnaire> {

    private static final String TAG = QuestionnaireActivity.class.getSimpleName().toString();

    private EditText nameField;
    private EditText descriptionField;
    private Spinner typeSpinner;
    private ArrayAdapter<QuestionnaireType> typeAdapter;
    private Button addQuestionsButton;
    private Button updateButton;
    private Button submitButton;


    void setUI(Questionnaire entry) {
        nameField.setText(entry.getName());
        descriptionField.setText(entry.getDescription());

        int i = 0;
        for (i = 0; i < typeAdapter.getCount(); i++) {
            QuestionnaireType type = typeAdapter.getItem(i);
            if (type.getId().equals(entry.getTypeId())) {
                break;
            }
        }
        typeSpinner.setSelection(0); //TODO
    }

    void handleResultGet(int requestCode, Intent data) {
        //TODO
    }

    void setEntryByUI() {
        QuestionnaireType type = (QuestionnaireType) typeSpinner.getSelectedItem();

        entry.setName(nameField.getText().toString());
        entry.setDescription(descriptionField.getText().toString());
        entry.setTypeId(type.getId());
    }

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questionnaire);

        nameField = this.findViewById(R.id.questionnaire_name_field);
        descriptionField = this.findViewById(R.id.questionnaire_description_field);
        typeSpinner = this.findViewById(R.id.questionnaire_type_spinner);

        List<QuestionnaireType> types = QUESTIONNAIRE_TYPE_TABLE.getAll();
        typeAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                types);
        typeSpinner.setAdapter(typeAdapter);
        typeSpinner.setSelected(false);
        typeSpinner.setOnItemSelectedListener(new EntryOnItemSelectedListener<QuestionnaireType>());

        addQuestionsButton = findViewById(R.id.questionnaire_add_questions_button);
        addQuestionsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = AddQuestionsActivity.newIntent(QuestionnaireActivity.this, entry);
                startActivity(i);
            }
        });

        updateButton = this.findViewById(R.id.questionnaire_update_button);
        updateButton.setOnClickListener(new UpdateButtonOnClickListener(QUESTIONNAIRE_TABLE));

        submitButton = this.findViewById(R.id.questionnaire_submit_button);
        submitButton.setOnClickListener(new SubmitButtonOnClickListener(QUESTIONNAIRE_TABLE));

        if (getIntent().getFlags() == Table.FLAG_EDIT_ENTRY) {
            entry = getEntry(getIntent());
            setUI(entry);
            updateButton.setVisibility(View.VISIBLE);
            submitButton.setVisibility(View.GONE);
        } else {
            entry = new Questionnaire();
            updateButton.setVisibility(View.GONE);
            submitButton.setVisibility(View.VISIBLE);
        }
    }

    protected boolean validateEntry(){
        boolean valid = true;

        if (nameField.getText().toString().trim().isEmpty()) {
            nameField.setError("This field is required");
            valid = false;
        }
        if (typeSpinner.getSelectedItem() == null){
            nameField.setError("This field is required");
            valid = false;
        }

        if (!valid){
            Toast.makeText(this, "Please Fill in All Required Fields", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }
}
