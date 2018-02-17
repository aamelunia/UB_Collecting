package edu.buffalo.cse.ubcollecting.data;

/**
 * Created by Aamel Unia on 2/17/18.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import edu.buffalo.cse.ubcollecting.app.App;

import edu.buffalo.cse.ubcollecting.data.models.Person;
import edu.buffalo.cse.ubcollecting.data.tables.PersonTable;
import edu.buffalo.cse.ubcollecting.data.models.Questionnaire;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionnaireTable;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = DatabaseHelper.class.getSimpleName().toString();


    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Collection";


    public DatabaseHelper() {
        super(App.getContext(), DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Creating The Tables
        db.execSQL(PersonTable.createTable());
        db.execSQL(QuestionnaireTable.createTable());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.d(TAG, String.format("SQLiteDatabase.onUpgrade(%d -> %d)", oldVersion, newVersion));

        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + Person.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Questionnaire.TABLE);

        // create new tables
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
