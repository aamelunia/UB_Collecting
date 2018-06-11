package edu.buffalo.cse.ubcollecting;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.Serializable;

import edu.buffalo.cse.ubcollecting.data.models.FieldTrip;
import edu.buffalo.cse.ubcollecting.data.models.Session;

import static edu.buffalo.cse.ubcollecting.data.DatabaseHelper.SESSION_TABLE;
import static edu.buffalo.cse.ubcollecting.ui.UserLandingActivity.SELECTED_FIELD_TRIP;

public class SessionActivity extends AppCompatActivity {

    private static final String TAG = SessionActivity.class.getSimpleName().toString();

    private EditText labelField;
    private EditText nameField;
    private EditText startTimeField;
    private EditText locationField;
    private EditText descriptionField;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session);

        labelField = this.findViewById(R.id.session_label_field);
        nameField = this.findViewById(R.id.session_name_field);
        startTimeField = this.findViewById(R.id.session_start_time_field);
        locationField = this.findViewById(R.id.session_location_field);
        descriptionField = this.findViewById(R.id.session_description_field);
        submitButton = this.findViewById(R.id.session_submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Session session = new Session();
                session.setLabel(labelField.getText().toString());
                session.setName(nameField.getText().toString());
                session.setStartTime(startTimeField.getText().toString());
                session.setLocation(locationField.getText().toString());
                session.setDescription(descriptionField.getText().toString());

                SESSION_TABLE.insert(session);
            }
        });
    }



    /**
     * Helper function to extract a {@link edu.buffalo.cse.ubcollecting.data.models.FieldTrip} extra from and {@link Intent}
     * @param data {@link Intent} holding the extra
     * @return {@link edu.buffalo.cse.ubcollecting.data.models.FieldTrip} extra from {@link Intent}
     */
    public static FieldTrip getFieldTrip(Intent data) {
        Serializable serializableObject = data.getSerializableExtra(SELECTED_FIELD_TRIP);

        return (FieldTrip) serializableObject;
    }
}
