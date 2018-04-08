package edu.buffalo.cse.ubcollecting.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import edu.buffalo.cse.ubcollecting.R;

public class UserActivity extends AppCompatActivity {

    public static Intent newIntent(Context packageContext) {
        Intent i = new Intent(packageContext, UserActivity.class);
        return i;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
    }
}
