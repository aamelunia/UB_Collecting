package edu.buffalo.cse.ubcollecting.data;

/**
 * Created by Aamel Unia on 2/17/18.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.database.Cursor;


import java.util.ArrayList;
import java.util.List;

import edu.buffalo.cse.ubcollecting.app.App;

import edu.buffalo.cse.ubcollecting.data.models.Person;
import edu.buffalo.cse.ubcollecting.data.tables.PersonTable;
import edu.buffalo.cse.ubcollecting.data.models.Questionnaire;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionnaireTable;
import edu.buffalo.cse.ubcollecting.data.models.QuestionnaireType;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionnaireTypeTable;
import edu.buffalo.cse.ubcollecting.data.models.QuestionnaireContent;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionnaireContentTable;
import edu.buffalo.cse.ubcollecting.data.models.Language;
import edu.buffalo.cse.ubcollecting.data.tables.LanguageTable;
import edu.buffalo.cse.ubcollecting.data.models.Role;
import edu.buffalo.cse.ubcollecting.data.tables.RoleTable;
import edu.buffalo.cse.ubcollecting.data.models.FieldTrip;
import edu.buffalo.cse.ubcollecting.data.tables.FieldTripTable;
import edu.buffalo.cse.ubcollecting.data.models.File;
import edu.buffalo.cse.ubcollecting.data.tables.FileTable;
import edu.buffalo.cse.ubcollecting.data.models.Session;
import edu.buffalo.cse.ubcollecting.data.tables.SessionTable;



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
        db.execSQL(QuestionnaireTypeTable.createTable());
        db.execSQL(LanguageTable.createTable());
        db.execSQL(RoleTable.createTable());
        db.execSQL(FieldTripTable.createTable());
        db.execSQL(FileTable.createTable());
        db.execSQL(SessionTable.createTable());
        db.execSQL(QuestionnaireContentTable.createTable());



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.d(TAG, String.format("SQLiteDatabase.onUpgrade(%d -> %d)", oldVersion, newVersion));

        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + Person.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Questionnaire.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionnaireType.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Language.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Role.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + FieldTrip.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + File.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Session.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionnaireContent.TABLE);

        // create new tables
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


    // Generalized and Abstracted out Select All Method for All Tables

    public static List<StringBuffer> getAll (String tableName) {

        List<StringBuffer> storage = new ArrayList<StringBuffer>();

        String selectQuery = "SELECT  * FROM " + tableName;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
               int totalFields = cursor.getColumnCount();
               StringBuffer sb = new StringBuffer();

                for (int i = 0; i < totalFields ; i++) {
                    sb.append(cursor.getColumnName(i));
                    sb.append(": ");
                    sb.append(cursor.getString(i));
                    sb.append(" ");
                }

                storage.add(sb);

            } while (cursor.moveToNext());
        }

        DatabaseManager.getInstance().closeDatabase();

        return storage;
    }

}
