package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import edu.buffalo.cse.ubcollecting.PersonActivity;
import edu.buffalo.cse.ubcollecting.data.models.Person;


public class PersonTable extends MainTable<Person> {

    public static final String TABLE = "Person";

    // Person Table - column names
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "Name";
    public static final String KEY_OTHER_NAMES = "OtherNames";
    public static final String KEY_DOB = "DOB";
    public static final String KEY_PHOTO_PATH = "PhotoPath";
    public static final String KEY_PHOTO_DESC = "PhotoDesc";
    public static final String KEY_MAIN_ROLE_ID = "MainRoleId";
    public static final String KEY_INTRO_QUEST_DESC = "IntroQuestDesc";

    public PersonTable() {
        super();
        activityClass = PersonActivity.class;
    }

    @Override
//    CHANGED PHOTO TYPE TO VARCHAR INSTEAD OF BLOB, NOT SURE IF WILL WORK
    public String createTable() {
        Log.i("PERSON TABLE:", TABLE);
        return "CREATE TABLE "
                + TABLE + "( " + KEY_ID + " TEXT PRIMARY KEY, " + KEY_NAME
                + " VARCHAR, " + KEY_OTHER_NAMES + " VARCHAR, " + KEY_DOB
                + " DATETIME, " + KEY_MAIN_ROLE_ID + " TEXT," + KEY_PHOTO_PATH + " VARCHAR, "
                + KEY_PHOTO_DESC + " VARCHAR, " + KEY_INTRO_QUEST_DESC + " VARCHAR,"
                + " FOREIGN KEY (" + KEY_MAIN_ROLE_ID + ") REFERENCES " + RoleTable.TABLE
                + " (" + RoleTable.KEY_ID + ")" + ")";
    }

    @Override
    public String getTableName() {
        return TABLE;
    }


    public Bitmap getImage(String url){

        Bitmap bt = null;
        try {
            FileInputStream fs = new FileInputStream(url);
            byte[] imgbyte = new byte[fs.available()];
            fs.read(imgbyte);
            fs.close();
            bt = BitmapFactory.decodeByteArray(imgbyte,0,imgbyte.length);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bt;
    }

}
