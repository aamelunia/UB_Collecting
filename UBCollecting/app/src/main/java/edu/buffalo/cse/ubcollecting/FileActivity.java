package edu.buffalo.cse.ubcollecting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

import edu.buffalo.cse.ubcollecting.data.models.File;
import edu.buffalo.cse.ubcollecting.data.tables.FileTable;

public class FileActivity extends AppCompatActivity {

    private static final String TAG = FileActivity.class.getSimpleName().toString();

    private TextView idField;
    private EditText fileNameField;
    private EditText answerIdField;
    private EditText fileTypeField;
    private EditText filePathField;
    private EditText fileCreatorField;
    private EditText fileStartTimeField;
    private EditText fileEndTimeField;
    private Button submitButton;

    private FileTable fileTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file);

        idField = this.findViewById(R.id.file_id_field);
        idField.setText(UUID.randomUUID().toString());
        fileNameField = this.findViewById(R.id.file_name_field);
        answerIdField = this.findViewById(R.id.file_answer_id_field);
        fileTypeField = this.findViewById(R.id.file_type_field);
        filePathField = this.findViewById(R.id.file_path_field);
        fileCreatorField = this.findViewById(R.id.file_creator_field);
        fileStartTimeField = this.findViewById(R.id.file_start_time_field);
        fileEndTimeField = this.findViewById(R.id.file_end_time_field);
        submitButton = this.findViewById(R.id.file_submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                File file = new File();
                file.setId(idField.getText().toString());
                file.setName(fileNameField.getText().toString());
                file.setAnswerId(answerIdField.getText().toString());
                file.setType(fileTypeField.getText().toString());
                file.setPath(filePathField.getText().toString());
                file.setCreator(fileCreatorField.getText().toString());
                file.setStartTime(fileStartTimeField.getText().toString());
                file.setEndTime(fileEndTimeField.getText().toString());

                fileTable.addFile(file);
            }
        });
    }
}
