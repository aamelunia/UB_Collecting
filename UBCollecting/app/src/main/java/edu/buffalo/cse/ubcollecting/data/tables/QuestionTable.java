package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.Question;

public class QuestionTable {

    private Question question;

    public QuestionTable () {

        question = new Question();

    }

    public static String createTable(){
        //  Added primary key unlike in original script
        return "CREATE TABLE "
                + Question.TABLE + "(" + Question.KEY_QUESTION_ID + " TEXT PRIMARY KEY," + Question.KEY_QUESTION_TYPE
                + " VARCHAR" + ")";
    }

    public int addQuestion(Question question) {

        int questionId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        ContentValues values = new ContentValues();
        values.put(Question.KEY_QUESTION_ID, question.getId());
        values.put(Question.KEY_QUESTION_TYPE, question.getType());

        questionId = (int) db.insert(Question.TABLE,null,values);

        DatabaseManager.getInstance().closeDatabase();

        return questionId;

    }

}
