package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.Answer;
import edu.buffalo.cse.ubcollecting.data.models.Question;
import edu.buffalo.cse.ubcollecting.data.models.Questionnaire;
import edu.buffalo.cse.ubcollecting.data.models.Session;
import edu.buffalo.cse.ubcollecting.data.models.SessionAnswer;

public class SessionAnswerTable {

    private SessionAnswer sessionAnswer;

    public SessionAnswerTable () {

        sessionAnswer = new SessionAnswer();

    }

    public static String createTable(){

        return "CREATE TABLE "
                + SessionAnswer.TABLE + "(" + SessionAnswer.KEY_SESSION_ID + " INTEGER,"
                + SessionAnswer.KEY_QUESTIONNAIRE_ID + " INTEGER," + SessionAnswer.KEY_QUESTION_ID + " INTEGER,"
                + SessionAnswer.KEY_ANSWER_ID + " INTEGER,"
                + " FOREIGN KEY(" + SessionAnswer.KEY_QUESTIONNAIRE_ID + ") REFERENCES " + Questionnaire.TABLE
                + " (" + Questionnaire.KEY_ID + "),"
                + " FOREIGN KEY(" + SessionAnswer.KEY_QUESTION_ID + ") REFERENCES " + Question.TABLE
                + " (" + Question.KEY_ID + "),"
                + " FOREIGN KEY(" + SessionAnswer.KEY_ANSWER_ID + ") REFERENCES " + Answer.TABLE
                + " (" + Answer.KEY_ID + "),"
                + " FOREIGN KEY(" + SessionAnswer.KEY_SESSION_ID + ") REFERENCES " + Session.TABLE
                + " (" + Session.KEY_ID + ")"
                + ")";
    }

    public static int addSessionAnswer(SessionAnswer sessionAnswer) {

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
