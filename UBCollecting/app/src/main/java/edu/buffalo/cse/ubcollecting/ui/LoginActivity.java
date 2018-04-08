package edu.buffalo.cse.ubcollecting.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import edu.buffalo.cse.ubcollecting.R;
import edu.buffalo.cse.ubcollecting.data.DatabaseManager;

import static edu.buffalo.cse.ubcollecting.data.DatabaseHelper.PERSON_TABLE;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = LoginActivity.class.getSimpleName();

    public static final String USER_INFO_PREF_KEY = "edu.buffalo.cse.ubcollecting.user_info_pref_key";
    public static final String USER_ID_KEY = "edu.buffalo.cse.ubcollecting.user_id_key";
    public static final String USER_ROLE_KEY = "edu.buffalo.cse.ubcollecting.user_role_key";

    private EditText emailField;
    private EditText passwordField;
    private TextView errorText;
    private Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        DatabaseManager.getInstance().openDatabase();

        emailField = findViewById(R.id.login_email_field);
        passwordField= findViewById(R.id.login_password_field);
        errorText = findViewById(R.id.login_error_text);
        loginButton = findViewById(R.id.login_login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailField.getText().toString();
                String password = passwordField.getText().toString();

                String[] info = PERSON_TABLE.validateUser(email,password);

                if (info == null) {
                    errorText.setVisibility(View.VISIBLE);
                    emailField.setText("");
                    passwordField.setText("");
                } else {
                    String id = info[0];
                    String role = info[1];

                    errorText.setVisibility(View.INVISIBLE);
                    SharedPreferences userInfoPreferences =
                            getSharedPreferences(USER_INFO_PREF_KEY, Activity.MODE_PRIVATE);
                    userInfoPreferences.edit().putString(USER_ID_KEY, id).apply();
                    userInfoPreferences.edit().putString(USER_ROLE_KEY, role).apply();

                    Intent i;
                    if(role.equals("ADMIN")) {
                        i = AdminActivity.newIntent(LoginActivity.this);
                    } else {
                        i = UserActivity.newIntent(LoginActivity.this);
                    }
                    startActivity(i);
                }
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.i(TAG, "Number of users: "  + PERSON_TABLE.getAll().size());
        if(PERSON_TABLE.getAll().isEmpty()) {
            Intent i = PERSON_TABLE.insertActivityIntent(LoginActivity.this);
            startActivity(i);
        }
    }
}
