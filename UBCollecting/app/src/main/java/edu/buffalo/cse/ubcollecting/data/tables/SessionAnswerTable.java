package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.SessionAnswer;

public class SessionAnswerTable {

    private SessionAnswer sessionAnswer;

    public SessionAnswerTable () {

        sessionAnswer = new SessionAnswer();

    }

    public static String createTable(){
        //  Add primary key? How about all the foreign keys?!
        return "CREATE TABLE "
                + SessionAnswer.TABLE + "(" + SessionAnswer.KEY_SESSION_ID + " TEXT," + SessionAnswer.KEY_QUESTIONNAIRE_ID
                + " TEXT," + SessionAnswer.KEY_QUESTION_ID + " TEXT," + SessionAnswer.KEY_ANSWER_ID
                + " TEXT" + ")";
    }

    public int addSessionAnswer(SessionAnswer sessionAnswer) {

        int sessionAnswerId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(SessionAnswer.KEY_SESSION_ID, sessionAnswer.getSessionId());
        values.put(SessionAnswer.KEY_QUESTIONNAIRE_ID, sessionAnswer.getQuestionnaireId());
        values.put(SessionAnswer.KEY_QUESTION_ID, sessionAnswer.getQuestionId());
        values.put(SessionAnswer.KEY_ANSWER_ID, sessionAnswer.getAnswerId());


        sessionAnswerId = (int) db.insert(SessionAnswer.TABLE,null,values);

        DatabaseManager.getInstance().closeDatabase();

        return sessionAnswerId;

    }

}
