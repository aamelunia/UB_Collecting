package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */

import android.util.Log;

import edu.buffalo.cse.ubcollecting.data.models.Person;


public class PersonTable extends MainTable<Person> {

    public static final String TABLE = "Person";

    // Person Table - column names
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "Name";
    public static final String KEY_OTHER_NAMES = "OtherNames";
    public static final String KEY_DOB = "DOB";
    public static final String KEY_PHOTO = "Photo";
    public static final String KEY_PHOTO_DESC = "PhotoDesc";
    public static final String KEY_MAIN_ROLE_ID = "MainRoleId";
    public static final String KEY_INTRO_QUEST_DESC = "IntroQuestDesc";

    public PersonTable() {
        super();
    }

    @Override
    public String createTable() {
        Log.i("PERSON TABLE:", TABLE);
        return "CREATE TABLE "
                + TABLE + "( " + KEY_ID + " TEXT PRIMARY KEY, " + KEY_NAME
                + " VARCHAR, " + KEY_OTHER_NAMES + " VARCHAR, " + KEY_DOB
                + " DATETIME, " + KEY_MAIN_ROLE_ID + " TEXT," + KEY_PHOTO + " BLOB, "
                + KEY_PHOTO_DESC + " VARCHAR, " + KEY_INTRO_QUEST_DESC + " VARCHAR,"
                + " FOREIGN KEY (" + KEY_MAIN_ROLE_ID + ") REFERENCES " + RoleTable.TABLE
                + " (" + RoleTable.KEY_ID + ")" + ")";
    }

    @Override
    public String getTableName() {
        return TABLE;
    }
}
