package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.Answer;

public class AnswerTable {

    private Answer answer;

    public AnswerTable () {

        answer = new Answer();

    }

    public static String createTable(){
        //  Add primary key? How about all the foreign keys?!
        return "CREATE TABLE "
                + Answer.TABLE + "(" + Answer.KEY_ANSWER_ID+ " TEXT PRIMARY KEY," + Answer.KEY_QUESTIONNAIRE_ID
                + " TEXT," + Answer.KEY_QUESTION_ID+ " TEXT," + Answer.KEY_ANSWER_LABEL
                + " VARCHAR," + Answer.KEY_ANSWER_TEXT + " VARCHAR" + ")";
    }

    public int addAnswer(Answer answer) {

        int answerId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Answer.KEY_ANSWER_ID, answer.getId());
        values.put(Answer.KEY_QUESTIONNAIRE_ID, answer.getQuestionnaireId());
        values.put(Answer.KEY_QUESTION_ID, answer.getQuestionId());
        values.put(Answer.KEY_ANSWER_LABEL, answer.getLabel());
        values.put(Answer.KEY_ANSWER_TEXT, answer.getText());


        answerId = (int) db.insert(Answer.TABLE,null,values);

        DatabaseManager.getInstance().closeDatabase();

        return answerId;

    }

}
