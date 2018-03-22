package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.Answer;
import edu.buffalo.cse.ubcollecting.data.models.Question;
import edu.buffalo.cse.ubcollecting.data.models.Questionnaire;
import edu.buffalo.cse.ubcollecting.data.models.QuestionnaireType;

public class AnswerTable {

    private Answer answer;

    public AnswerTable () {

        answer = new Answer();

    }

    public static String createTable(){
        return "CREATE TABLE "
                + Answer.TABLE + "(" + Answer.KEY_ID + " TEXT," + Answer.KEY_QUESTIONNAIRE_ID
                + " TEXT," + Answer.KEY_QUESTION_ID + " TEXT," + Answer.KEY_ANSWER_LABEL + " VARCHAR,"
                + Answer.KEY_ANSWER_TEXT + " VARCHAR,"
                + " PRIMARY KEY("+ Answer.KEY_QUESTIONNAIRE_ID+", "+Answer.KEY_QUESTION_ID+", "+Answer.KEY_ID+"),"
                + " FOREIGN KEY(" + Answer.KEY_QUESTION_ID + ") REFERENCES " + Question.TABLE
                + " (" + Question.KEY_ID + ")," + " FOREIGN KEY(" + Answer.KEY_QUESTIONNAIRE_ID + ") REFERENCES "
                + Questionnaire.TABLE + " (" + Questionnaire.KEY_ID + ")" + ")";
    }

    public static int addAnswer(Answer answer) {

        int answerId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Answer.KEY_ID, answer.getId());
        values.put(Answer.KEY_QUESTIONNAIRE_ID, answer.getQuestionnaireId());
        values.put(Answer.KEY_QUESTION_ID, answer.getQuestionId());
        values.put(Answer.KEY_ANSWER_LABEL, answer.getLabel());
        values.put(Answer.KEY_ANSWER_TEXT, answer.getText());


        answerId = (int) db.insert(Answer.TABLE,null,values);

        DatabaseManager.getInstance().closeDatabase();

        return answerId;

    }

}
