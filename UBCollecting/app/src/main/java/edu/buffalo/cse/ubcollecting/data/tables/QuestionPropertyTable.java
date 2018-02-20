package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.QuestionProperty;

public class QuestionPropertyTable {

    private QuestionProperty questionProperty;

    public QuestionPropertyTable () {

        questionProperty = new QuestionProperty();

    }

    public static String createTable(){
        //  Foreign keys?!
        return "CREATE TABLE "
                + QuestionProperty.TABLE + "(" + QuestionProperty.KEY_QUESTION_ID + " TEXT," + QuestionProperty.KEY_QUESTION_PROPERTY_ID
                + " TEXT," + QuestionProperty.KEY_QUESTION_PROPERTY_VALUE + " INTEGER"+ ")";
    }

    public int addQuestionProperty(QuestionProperty questionProperty) {

        int questionPropertyId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        ContentValues values = new ContentValues();
        values.put(QuestionProperty.KEY_QUESTION_ID, questionProperty.getQuestionId());
        values.put(QuestionProperty.KEY_QUESTION_PROPERTY_ID, questionProperty.getPropertyId());
        values.put(QuestionProperty.KEY_QUESTION_PROPERTY_VALUE, questionProperty.getValue());

        questionPropertyId = (int) db.insert(QuestionProperty.TABLE,null,values);

        DatabaseManager.getInstance().closeDatabase();

        return questionPropertyId;

    }

}
