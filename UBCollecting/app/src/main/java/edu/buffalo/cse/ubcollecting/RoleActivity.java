package edu.buffalo.cse.ubcollecting;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.UUID;

import edu.buffalo.cse.ubcollecting.data.DatabaseHelper;
import edu.buffalo.cse.ubcollecting.data.models.Role;
import edu.buffalo.cse.ubcollecting.data.tables.PersonTable;
import edu.buffalo.cse.ubcollecting.data.tables.RoleTable;

import static edu.buffalo.cse.ubcollecting.app.App.getContext;
import static edu.buffalo.cse.ubcollecting.data.DatabaseHelper.ROLE_TABLE;

public class RoleActivity extends AppCompatActivity {

    private static final String TAG = RoleActivity.class.getSimpleName().toString();
    private static final String EXTRA_ROLE_NAME = "edu.buffalo.cse.ubcollecting.role_name";
    private static final String EXTRA_ROLE_ID = "edu.buffalo.cse.ubcollecting.role_id";

    private EditText nameField;
    private CheckBox introRequiredBox;
    private CheckBox photoRequiredBox;
    private CheckBox onClientBox;
    private Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);

        nameField = this.findViewById(R.id.role_name_field);
        introRequiredBox = this.findViewById(R.id.role_intro_required_box);
        photoRequiredBox = this.findViewById(R.id.role_photo_required_box);
        onClientBox = this.findViewById(R.id.role_on_client_box);
        submitButton = this.findViewById(R.id.role_submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Role role = new Role();
                role.setName(nameField.getText().toString());
                role.setIntroRequired((introRequiredBox.isChecked()) ? 1 : 0);
                role.setPhotoRequired((photoRequiredBox.isChecked()) ? 1 : 0);
                role.setOnClient((onClientBox.isChecked()) ? 1 : 0);

                ROLE_TABLE.addEntry(role);
                setRoleCreatedResult(role);
                Toast.makeText(getContext(), "Role created", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, RoleActivity.class);
        return i;
    }

    public static String getName(Intent result) {
        return result.getStringExtra(EXTRA_ROLE_NAME);
    }

    public static String getId(Intent result) {
        return result.getStringExtra(EXTRA_ROLE_ID);
    }

    private void setRoleCreatedResult(Role role) {
        Intent data = new Intent();
        data.putExtra(EXTRA_ROLE_NAME, role.getName());
        data.putExtra(EXTRA_ROLE_ID, role.getId());
        setResult(RESULT_OK, data);
    }
}
