package edu.buffalo.cse.ubcollecting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

import edu.buffalo.cse.ubcollecting.data.models.LanguageType;
import edu.buffalo.cse.ubcollecting.data.tables.LanguageTypeTable;

public class LanguageTypeActivity extends AppCompatActivity {

    private static final String TAG = LanguageTypeActivity.class.getSimpleName().toString();

    private TextView idField;
    private EditText nameField;
    private Button submitButton;

    private LanguageTypeTable languageTypeTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_type);

        idField = this.findViewById(R.id.language_type_id_field);
        idField.setText(UUID.randomUUID().toString());
        nameField = this.findViewById(R.id.language_type_name_field);
        submitButton = this.findViewById(R.id.language_type_submit_button);

        languageTypeTable = new LanguageTypeTable();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LanguageType langType = new LanguageType();
                langType.setId(idField.getText().toString());
                langType.setName(nameField.getText().toString());

                languageTypeTable.addLanguageType(langType);
            }
        });
    }
}
