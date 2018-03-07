package edu.buffalo.cse.ubcollecting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.UUID;

import edu.buffalo.cse.ubcollecting.data.models.FieldTrip;
import edu.buffalo.cse.ubcollecting.data.tables.FieldTripTable;
import edu.buffalo.cse.ubcollecting.data.tables.PersonTable;

public class FieldTripActivity extends AppCompatActivity {

    private static final String TAG = FieldTripActivity.class.getSimpleName().toString();

    private EditText nameField;
    private EditText startDateField;
    private EditText endDateField;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fieldtrip);

        nameField = this.findViewById(R.id.fieldtrip_name_field);
        startDateField = this.findViewById(R.id.fieldtrip_start_date_field);
        endDateField = this.findViewById(R.id.fieldtrip_end_date_field);
        submitButton = this.findViewById(R.id.fieldtrip_submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FieldTrip trip = new FieldTrip();
                trip.setName(nameField.getText().toString());
                trip.setStartDate(startDateField.getText().toString());
                trip.setEndDate(endDateField.getText().toString());

                int id = FieldTripTable.addFieldTrip(trip);
                trip.setId(id);
            }
        });
    }
}
