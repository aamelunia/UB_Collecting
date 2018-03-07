package edu.buffalo.cse.ubcollecting;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import edu.buffalo.cse.ubcollecting.data.models.Language;
import edu.buffalo.cse.ubcollecting.data.tables.LanguageTable;

public class LanguageActivity extends AppCompatActivity {

    private static final String TAG = LanguageActivity.class.getSimpleName().toString();

    private EditText nameField;
    private EditText otherNamesField;
    private EditText descriptionField;
    private EditText typeField;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);

        nameField = this.findViewById(R.id.language_name_field);
        otherNamesField = this.findViewById(R.id.language_other_names_field);
        descriptionField = this.findViewById(R.id.language_description_field);
        typeField = this.findViewById(R.id.language_langtype_field);
        submitButton = this.findViewById(R.id.language_submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Language lang = new Language();
                lang.setName(nameField.getText().toString());
                lang.setOtherNames(otherNamesField.getText().toString());
                lang.setDescription(descriptionField.getText().toString());
                lang.setTypeId(0); // TODO

                int id = LanguageTable.addLanguage(lang);

                lang.setId(id);
            }
        });
    }
}
