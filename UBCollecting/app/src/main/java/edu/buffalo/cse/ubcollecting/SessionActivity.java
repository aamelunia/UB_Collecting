package edu.buffalo.cse.ubcollecting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

import edu.buffalo.cse.ubcollecting.data.models.Session;
import edu.buffalo.cse.ubcollecting.data.tables.PersonTable;
import edu.buffalo.cse.ubcollecting.data.tables.SessionTable;

public class SessionActivity extends AppCompatActivity {

    private static final String TAG = SessionActivity.class.getSimpleName().toString();

    private TextView idField;
    private EditText labelField;
    private EditText nameField;
    private EditText startTimeField;
    private EditText locationField;
    private EditText descriptionField;
    private Button submitButton;

    private SessionTable sessionTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);

        idField = this.findViewById(R.id.session_id_field);
        idField.setText(UUID.randomUUID().toString());
        labelField = this.findViewById(R.id.session_label_field);
        nameField = this.findViewById(R.id.session_name_field);
        startTimeField = this.findViewById(R.id.session_start_time_field);
        locationField = this.findViewById(R.id.session_location_field);
        descriptionField = this.findViewById(R.id.session_description_field);
        submitButton = this.findViewById(R.id.session_submit_button);

        sessionTable = new SessionTable();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Session session = new Session();
                session.setId(idField.getText().toString());
                session.setLabel(labelField.getText().toString());
                session.setName(nameField.getText().toString());
                session.setStartTime(startTimeField.getText().toString());
                session.setLocation(locationField.getText().toString());
                session.setDescription(descriptionField.getText().toString());

                sessionTable.addSession(session);
            }
        });
    }
}
