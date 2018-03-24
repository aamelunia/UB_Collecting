package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.QuestionPropertyDef;

public class QuestionPropertyDefTable {

    public static final String TABLE = "QuestionPropertyDef";

    // QuestionPropertyDef Table - column names
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "Name";

    public QuestionPropertyDefTable () {

    }

    public static String createTable(){
        return "CREATE TABLE "
                + TABLE + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME + " VARCHAR" + ")";
    }

//    public static int addQuestionPropertyDef(QuestionPropertyDef questionPropertyDef) {
//
//        int questionPropertyDefId;
//
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(QuestionPropertyDef.KEY_ID, questionPropertyDef.getId());
//        values.put(QuestionPropertyDef.KEY_NAME, questionPropertyDef.getName());
//
//        questionPropertyDefId = (int) db.insert(QuestionPropertyDef.TABLE,null,values);
//
//        DatabaseManager.getInstance().closeDatabase();
//
//        return questionPropertyDefId;
//
//    }

}
