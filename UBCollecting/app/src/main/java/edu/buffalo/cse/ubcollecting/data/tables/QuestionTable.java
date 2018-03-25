package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.Question;

public class QuestionTable extends Table<Question> {

    // Question (QuestionPool) Table - column names
    public static final String KEY_ID = "id";
    public static final String KEY_TYPE = "Type";

    public QuestionTable () {
        super();
        TABLE = "Question";
    }

    @Override
    public String createTable(){
        return "CREATE TABLE "
                + TABLE + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_TYPE + " VARCHAR" + ")";
    }

//    public static int addQuestion(Question question) {
//
//        int questionId;
//
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(Question.KEY_ID, question.getId());
//        values.put(Question.KEY_TYPE, question.getType());
//
//        questionId = (int) db.insert(Question.TABLE,null,values);
//
//        DatabaseManager.getInstance().closeDatabase();
//
//        return questionId;
//
//    }

}
