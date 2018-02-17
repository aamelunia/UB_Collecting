package edu.buffalo.cse.ubcollecting.dbcode;

/**
 * Created by Aamel Unia on 2/17/18.
 */
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "Collection";

    // Table Names
    private static final String TABLE_PERSON = "Person";

    // Person Table - column names
    private static final String KEY_PERSON_ID = "PersonId";
    private static final String KEY_PERSON_NAME = "PersonName";
    private static final String KEY_PERSON_OTHER_NAMES = "PersonOtherNames";
//  Need to appropriately configure types for DOB and Photo
    private static final String KEY_PERSON_DOB = "PersonDOB";
    private static final String KEY_PERSON_PHOTO = "PersonPhoto";
    private static final String KEY_PERSON_PHOTO_DESC = "PersonPhotoDesc";
    private static final String KEY_PERSON_ROLE = "PersonMainRole";
    private static final String KEY_PERSON_INTO_QUES_DESC = "PersonIntroQuestnirDesc";

    // Table Create Statements

    // Person Table Create Statement
    private static final String CREATE_TABLE_PERSON = "CREATE TABLE "
            + TABLE_PERSON + "(" + KEY_PERSON_ID + " TEXT," + KEY_PERSON_NAME
            + " VARCHAR," + KEY_PERSON_OTHER_NAMES + " VARCHAR," + KEY_PERSON_DOB
            + " DATETIME," + KEY_PERSON_ROLE + " TEXT," + KEY_PERSON_PHOTO
            + " BLOB," + KEY_PERSON_PHOTO_DESC + " VARCHAR," + KEY_PERSON_INTO_QUES_DESC
            + " VARCHAR" + ")";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        //Creating The Tables
        db.execSQL(CREATE_TABLE_PERSON);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PERSON);

        // create new tables
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }

}
