package edu.buffalo.cse.ubcollecting.ui.interviewer;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import edu.buffalo.cse.ubcollecting.R;


/**
 * Created by aamel786 on 6/13/18.
 */

public class AddSessionRolesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_session_roles);

    }


    public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, AddSessionRolesActivity.class);
        return i;
    }

}
