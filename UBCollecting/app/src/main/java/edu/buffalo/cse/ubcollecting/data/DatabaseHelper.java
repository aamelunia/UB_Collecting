package edu.buffalo.cse.ubcollecting.data;

/**
 * Created by Aamel Unia on 2/17/18.
 */

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

import edu.buffalo.cse.ubcollecting.app.App;
import edu.buffalo.cse.ubcollecting.data.models.Role;
import edu.buffalo.cse.ubcollecting.data.tables.AnswerTable;
import edu.buffalo.cse.ubcollecting.data.tables.FieldTripTable;
import edu.buffalo.cse.ubcollecting.data.tables.FileTable;
import edu.buffalo.cse.ubcollecting.data.tables.LanguageTable;
import edu.buffalo.cse.ubcollecting.data.tables.LanguageTypeTable;
import edu.buffalo.cse.ubcollecting.data.tables.PersonTable;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionLangVersionTable;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionOptionTable;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionPropertyDefTable;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionPropertyTable;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionTable;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionnaireContentTable;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionnaireTable;
import edu.buffalo.cse.ubcollecting.data.tables.QuestionnaireTypeTable;
import edu.buffalo.cse.ubcollecting.data.tables.RoleTable;
import edu.buffalo.cse.ubcollecting.data.tables.SessionAnswerTable;
import edu.buffalo.cse.ubcollecting.data.tables.SessionPersonTable;
import edu.buffalo.cse.ubcollecting.data.tables.SessionTable;
import edu.buffalo.cse.ubcollecting.data.tables.Table;


public class DatabaseHelper extends SQLiteOpenHelper {

    public static final AnswerTable ANSWER_TABLE = new AnswerTable();
    public static final FieldTripTable FIELD_TRIP_TABLE = new FieldTripTable();
    public static final FileTable FILE_TABLE = new FileTable();
    public static final LanguageTable LANGUAGE_TABLE = new LanguageTable();
    public static final LanguageTypeTable LANGUAGE_TYPE_TABLE = new LanguageTypeTable();
    public static final PersonTable PERSON_TABLE = new PersonTable();
    public static final QuestionTable QUESTION_TABLE = new QuestionTable();
    public static final QuestionLangVersionTable QUESTION_LANG_VERSION_TABLE = new QuestionLangVersionTable();
    public static final QuestionnaireTable QUESTIONNAIRE_TABLE = new QuestionnaireTable();
    public static final QuestionnaireContentTable QUESTIONNAIRE_CONTENT_TABLE = new QuestionnaireContentTable();
    public static final QuestionnaireTypeTable QUESTIONNAIRE_TYPE_TABLE = new QuestionnaireTypeTable();
    public static final QuestionOptionTable QUESTION_OPTION_TABLE = new QuestionOptionTable();
    public static final QuestionPropertyTable QUESTION_PROPERTY_TABLE = new QuestionPropertyTable();
    public static final RoleTable ROLE_TABLE = new RoleTable();
    public static final SessionTable SESSION_TABLE = new SessionTable();
    public static final SessionAnswerTable SESSION_ANSWER_TABLE = new SessionAnswerTable();
    public static final SessionPersonTable SESSION_PERSON_TABLE = new SessionPersonTable();
    public static final QuestionPropertyDefTable QUESTION_PROPERTY_DEF_TABLE = new QuestionPropertyDefTable();
    public static final List<Table<?>> TABLES = Arrays.asList(
            ANSWER_TABLE,
            FIELD_TRIP_TABLE,
            FILE_TABLE,
            LANGUAGE_TABLE,
            LANGUAGE_TYPE_TABLE,
            PERSON_TABLE,
            QUESTION_TABLE,
            QUESTION_LANG_VERSION_TABLE,
            QUESTIONNAIRE_TABLE,
            QUESTIONNAIRE_CONTENT_TABLE,
            QUESTIONNAIRE_TYPE_TABLE,
            QUESTION_OPTION_TABLE,
            QUESTION_PROPERTY_TABLE,
            ROLE_TABLE,
            SESSION_TABLE,
            SESSION_ANSWER_TABLE,
            SESSION_PERSON_TABLE,
            QUESTION_PROPERTY_DEF_TABLE
    );
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

        db.execSQL("PRAGMA foreign_keys=ON");
        //Creating The Tables
        db.execSQL(PERSON_TABLE.createTable());
        db.execSQL(QUESTION_TABLE.createTable());
        db.execSQL(QUESTION_OPTION_TABLE.createTable());
        db.execSQL(QUESTION_PROPERTY_TABLE.createTable());
        db.execSQL(QUESTION_PROPERTY_DEF_TABLE.createTable());
        db.execSQL(QUESTION_LANG_VERSION_TABLE.createTable());
        db.execSQL(QUESTIONNAIRE_TABLE.createTable());
        db.execSQL(QUESTIONNAIRE_TYPE_TABLE.createTable());
        db.execSQL(QUESTIONNAIRE_CONTENT_TABLE.createTable());
        db.execSQL(LANGUAGE_TABLE.createTable());
        db.execSQL(LANGUAGE_TYPE_TABLE.createTable());
        db.execSQL(ROLE_TABLE.createTable());
        db.execSQL(FIELD_TRIP_TABLE.createTable());
        db.execSQL(FILE_TABLE.createTable());
        db.execSQL(SESSION_TABLE.createTable());
        db.execSQL(SESSION_ANSWER_TABLE.createTable());
        db.execSQL(SESSION_PERSON_TABLE.createTable());
        db.execSQL(ANSWER_TABLE.createTable());
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        Log.d(TAG, String.format("SQLiteDatabase.onUpgrade(%d -> %d)", oldVersion, newVersion));

        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + PersonTable.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionTable.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionOptionTable.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionPropertyTable.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionPropertyDefTable.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionLangVersionTable.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionnaireTable.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionnaireTypeTable.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionnaireContentTable.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + LanguageTypeTable.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + LanguageTable.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + RoleTable.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + FieldTripTable.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + FileTable.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + SessionTable.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + SessionAnswerTable.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + SessionPersonTable.TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + AnswerTable.TABLE);

        // create new tables
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

    public static void populateData() {
        Role admin = new Role();
        admin.setName("ADMIN");
        admin.setIntroRequired(0);
        admin.setPhotoRequired(0);
        admin.setOnClient(0);

        ROLE_TABLE.insert(admin);

        Role student = new Role();
        student.setName("STUDENT");
        student.setIntroRequired(1);
        student.setPhotoRequired(1);
        student.setOnClient(0);

        ROLE_TABLE.insert(student);
    }
}
