package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.QuestionPropertyDef;

public class QuestionPropertyDefTable {

    private QuestionPropertyDef questionPropertyDef;

    public QuestionPropertyDefTable () {

        questionPropertyDef = new QuestionPropertyDef();

    }

    public static String createTable(){
        return "CREATE TABLE "
                + QuestionPropertyDef.TABLE + "(" + QuestionPropertyDef.KEY_ID + " INTEGER PRIMARY KEY," + QuestionPropertyDef.KEY_PROPERTY_NAME
                + " VARCHAR" + ")";
    }

    public static int addQuestionPropertyDef(QuestionPropertyDef questionPropertyDef) {

        int questionPropertyDefId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        ContentValues values = new ContentValues();
        values.put(QuestionPropertyDef.KEY_PROPERTY_NAME, questionPropertyDef.getName());

        questionPropertyDefId = (int) db.insert(QuestionPropertyDef.TABLE,null,values);

        DatabaseManager.getInstance().closeDatabase();

        return questionPropertyDefId;

    }

}
