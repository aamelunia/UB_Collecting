package edu.buffalo.cse.ubcollecting;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.buffalo.cse.ubcollecting.data.models.SessionPerson;
import edu.buffalo.cse.ubcollecting.data.tables.SessionPersonTable;

public class SessionPersonActivity extends AppCompatActivity {

    private static final String TAG = SessionPersonActivity.class.getSimpleName().toString();

    private TextView idField;
    private EditText sessionIdField;
    private EditText roleIdField;
    private Button submitButton;

    private SessionPersonTable sessionPersonTable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_session_person);

        idField = this.findViewById(R.id.session_person_id_field);
        sessionIdField = this.findViewById(R.id.session_person_session_id_field);
        roleIdField = this.findViewById(R.id.session_person_role_id_field);
        submitButton = this.findViewById(R.id.session_person_submit_button);

        sessionPersonTable = new SessionPersonTable();

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SessionPerson person = new SessionPerson();
                person.setPersonId(idField.getText().toString());
                person.setSessionId(sessionIdField.getText().toString());
                person.setRoleId(roleIdField.getText().toString());

                sessionPersonTable.addSessionPerson(person);
            }
        });
    }
}
