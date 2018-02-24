package edu.buffalo.cse.ubcollecting.data;

/**
 * Created by Aamel Unia on 2/17/18.
 */
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.database.Cursor;


import java.util.ArrayList;
import java.util.List;

import edu.buffalo.cse.ubcollecting.app.App;

import edu.buffalo.cse.ubcollecting.data.models.Person;
import edu.buffalo.cse.ubcollecting.data.tables.PersonTable;
import edu.buffalo.cse.ubcollecting.data.models.Question;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionTable;
import edu.buffalo.cse.ubcollecting.data.models.QuestionOption;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionOptionTable;
import edu.buffalo.cse.ubcollecting.data.models.QuestionProperty;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionPropertyTable;
import edu.buffalo.cse.ubcollecting.data.models.QuestionPropertyDef;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionPropertyDefTable;
import edu.buffalo.cse.ubcollecting.data.models.QuestionLangVersion;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionLangVersionTable;
import edu.buffalo.cse.ubcollecting.data.models.Questionnaire;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionnaireTable;
import edu.buffalo.cse.ubcollecting.data.models.QuestionnaireType;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionnaireTypeTable;
import edu.buffalo.cse.ubcollecting.data.models.QuestionnaireContent;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionnaireContentTable;
import edu.buffalo.cse.ubcollecting.data.models.Language;
import edu.buffalo.cse.ubcollecting.data.tables.LanguageTable;
import edu.buffalo.cse.ubcollecting.data.models.LanguageType;
import edu.buffalo.cse.ubcollecting.data.tables.LanguageTypeTable;
import edu.buffalo.cse.ubcollecting.data.models.Role;
import edu.buffalo.cse.ubcollecting.data.tables.RoleTable;
import edu.buffalo.cse.ubcollecting.data.models.FieldTrip;
import edu.buffalo.cse.ubcollecting.data.tables.FieldTripTable;
import edu.buffalo.cse.ubcollecting.data.models.File;
import edu.buffalo.cse.ubcollecting.data.tables.FileTable;
import edu.buffalo.cse.ubcollecting.data.models.Session;
import edu.buffalo.cse.ubcollecting.data.tables.SessionTable;
import edu.buffalo.cse.ubcollecting.data.models.SessionAnswer;
import edu.buffalo.cse.ubcollecting.data.tables.SessionAnswerTable;
import edu.buffalo.cse.ubcollecting.data.models.SessionPerson;
import edu.buffalo.cse.ubcollecting.data.tables.SessionPersonTable;
import edu.buffalo.cse.ubcollecting.data.models.Answer;
import edu.buffalo.cse.ubcollecting.data.tables.AnswerTable;


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
        db.execSQL(QuestionTable.createTable());
        db.execSQL(QuestionOptionTable.createTable());
        db.execSQL(QuestionPropertyTable.createTable());
        db.execSQL(QuestionPropertyDefTable.createTable());
        db.execSQL(QuestionLangVersionTable.createTable());
        db.execSQL(QuestionnaireTable.createTable());
        db.execSQL(QuestionnaireTypeTable.createTable());
        db.execSQL(QuestionnaireContentTable.createTable());
        db.execSQL(LanguageTable.createTable());
        db.execSQL(LanguageTypeTable.createTable());
        db.execSQL(RoleTable.createTable());
        db.execSQL(FieldTripTable.createTable());
        db.execSQL(FileTable.createTable());
        db.execSQL(SessionTable.createTable());
        db.execSQL(SessionAnswerTable.createTable());
        db.execSQL(SessionPersonTable.createTable());
        db.execSQL(AnswerTable.createTable());

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.d(TAG, String.format("SQLiteDatabase.onUpgrade(%d -> %d)", oldVersion, newVersion));

        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + Person.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Question.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionOption.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionProperty.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionPropertyDef.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionLangVersion.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Questionnaire.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionnaireType.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionnaireContent.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Language.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + LanguageType.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Role.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + FieldTrip.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + File.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Session.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + SessionAnswer.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + SessionPerson.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + Answer.TABLE);

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
