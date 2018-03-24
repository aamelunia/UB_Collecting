package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
public class SessionAnswerTable {

    public static final String TABLE = "SessionAnswer";

    // SessionAnswer Table - column names
    public static final String KEY_SESSION_ID = "SessionId";
    public static final String KEY_QUESTIONNAIRE_ID = "QuestionnaireId";
    public static final String KEY_QUESTION_ID = "QuestionId";
    public static final String KEY_ANSWER_ID = "AnswerId";

    public SessionAnswerTable () {

    }

    public static String createTable(){

        return "CREATE TABLE "
                + TABLE + "(" + KEY_SESSION_ID + " TEXT,"
                + KEY_QUESTIONNAIRE_ID + " TEXT," + KEY_QUESTION_ID + " TEXT,"
                + KEY_ANSWER_ID + " TEXT,"
                + " PRIMARY KEY("+ KEY_SESSION_ID + ", " + KEY_QUESTIONNAIRE_ID +", "
                + KEY_QUESTION_ID + ", " + KEY_ANSWER_ID + "),"
                + " FOREIGN KEY(" + KEY_QUESTIONNAIRE_ID + ") REFERENCES " + QuestionnaireTable.TABLE
                + " (" + QuestionnaireTable.KEY_ID + "),"
                + " FOREIGN KEY(" + KEY_QUESTION_ID + ") REFERENCES " + QuestionTable.TABLE
                + " (" + QuestionTable.KEY_ID + "),"
                + " FOREIGN KEY(" + KEY_ANSWER_ID + ") REFERENCES " + AnswerTable.TABLE
                + " (" + AnswerTable.KEY_ID + "),"
                + " FOREIGN KEY(" + KEY_SESSION_ID + ") REFERENCES " + SessionTable.TABLE
                + " (" + SessionTable.KEY_ID + ")"
                + ")";
    }

//    public static int addSessionAnswer(SessionAnswer sessionAnswer) {
//
//        int sessionAnswerId;
//
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//        ContentValues values = new ContentValues();
//        values.put(SessionAnswer.KEY_SESSION_ID, sessionAnswer.getSessionId());
//        values.put(SessionAnswer.KEY_QUESTIONNAIRE_ID, sessionAnswer.getQuestionnaireId());
//        values.put(SessionAnswer.KEY_QUESTION_ID, sessionAnswer.getQuestionId());
//        values.put(SessionAnswer.KEY_ANSWER_ID, sessionAnswer.getAnswerId());
//
//
//        sessionAnswerId = (int) db.insert(SessionAnswer.TABLE,null,values);
//
//        DatabaseManager.getInstance().closeDatabase();
//
//        return sessionAnswerId;
//
//    }

}
