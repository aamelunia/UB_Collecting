package edu.buffalo.cse.ubcollecting;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import edu.buffalo.cse.ubcollecting.data.models.Role;
import edu.buffalo.cse.ubcollecting.data.tables.Table;

import static edu.buffalo.cse.ubcollecting.data.DatabaseHelper.ROLE_TABLE;

public class RoleActivity extends EntryActivity<Role> {

    private static final String TAG = RoleActivity.class.getSimpleName().toString();

    private EditText nameField;
    private CheckBox introRequiredBox;
    private CheckBox photoRequiredBox;
    private CheckBox onClientBox;
    private Button submitButton;

    public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, RoleActivity.class);
        return i;
    }

    public void handleResultGet(int requestCode, Intent data) {
        return;
    }

    @Override
    public void setUI(Role role) {
        nameField.setText(role.getName());
        introRequiredBox.setChecked(role.getIntroRequired() == 1);
        photoRequiredBox.setChecked(role.getPhotoRequired() == 1);
        onClientBox.setChecked(role.getOnClient() == 1);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_role);

        nameField = this.findViewById(R.id.role_name_field);
        introRequiredBox = this.findViewById(R.id.role_intro_required_box);
        photoRequiredBox = this.findViewById(R.id.role_photo_required_box);
        onClientBox = this.findViewById(R.id.role_on_client_box);
        submitButton = this.findViewById(R.id.role_submit_button);

        if (getIntent().extra) {
            Role entry = this.getEntry(getIntent());
            Log.i(TAG, entry.getName());
            setUI(entry);
        }

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Role role = new Role();
                role.setName(nameField.getText().toString());
                role.setIntroRequired((introRequiredBox.isChecked()) ? 1 : 0);
                role.setPhotoRequired((photoRequiredBox.isChecked()) ? 1 : 0);
                role.setOnClient((onClientBox.isChecked()) ? 1 : 0);

                ROLE_TABLE.insert(role);
                setEntryCreatedResult(role);
                finish();
            }
        });
    }
}
