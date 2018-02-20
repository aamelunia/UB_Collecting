package edu.buffalo.cse.ubcollecting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

import edu.buffalo.cse.ubcollecting.data.models.Language;
import edu.buffalo.cse.ubcollecting.data.tables.LanguageTable;

public class LanguageActivity extends AppCompatActivity {

    private static final String TAG = LanguageActivity.class.getSimpleName().toString();

    private TextView idField;
    private EditText nameField;
    private EditText otherNamesField;
    private EditText descriptionField;
    private EditText typeIdField;
    private Button submitButton;

    private LanguageTable languageTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        idField = this.findViewById(R.id.language_id_field);
        idField.setText(UUID.randomUUID().toString());
        nameField = this.findViewById(R.id.language_name_field);
        otherNamesField = this.findViewById(R.id.language_other_names_field);
        descriptionField = this.findViewById(R.id.language_description_field);
        typeIdField = this.findViewById(R.id.language_type_id_field);
        submitButton = this.findViewById(R.id.language_submit_button);

        languageTable = new LanguageTable();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Language lang = new Language();
                lang.setId(idField.getText().toString());
                lang.setName(nameField.getText().toString());
                lang.setOtherNames(otherNamesField.getText().toString());
                lang.setDescription(descriptionField.getText().toString());
                lang.setTypeId(descriptionField.getText().toString());

                languageTable.addLanguage(lang);
            }
        });
    }
}
