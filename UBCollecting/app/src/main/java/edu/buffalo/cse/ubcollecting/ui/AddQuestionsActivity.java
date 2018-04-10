package edu.buffalo.cse.ubcollecting.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import edu.buffalo.cse.ubcollecting.R;

public class AddQuestionsActivity extends AppCompatActivity {

    private static final String TAG = AddQuestionsActivity.class.getSimpleName().toString();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_questions);
    }
}
