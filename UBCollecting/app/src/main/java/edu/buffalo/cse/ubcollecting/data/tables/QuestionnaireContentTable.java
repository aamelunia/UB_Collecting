package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.Question;
import edu.buffalo.cse.ubcollecting.data.models.Questionnaire;
import edu.buffalo.cse.ubcollecting.data.models.QuestionnaireContent;

public class QuestionnaireContentTable {

    private QuestionnaireContent questionnaireContent;

    public QuestionnaireContentTable () {

        questionnaireContent = new QuestionnaireContent();

    }


    public static String createTable(){
        return "CREATE TABLE "
                + QuestionnaireContent.TABLE + "(" + QuestionnaireContent.KEY_QUESTIONNAIRE_ID + " INTEGER,"
                + QuestionnaireContent.KEY_QUESTION_ID + " INTEGER," + QuestionnaireContent.KEY_QUESTION_ORDER + " VARCHAR,"
                + " FOREIGN KEY(" + QuestionnaireContent.KEY_QUESTION_ID + ") REFERENCES " + Question.TABLE
                + " (" + Question.KEY_ID + ")," + " FOREIGN KEY(" + QuestionnaireContent.KEY_QUESTIONNAIRE_ID
                + ") REFERENCES " + Questionnaire.TABLE + " (" + Questionnaire.KEY_ID + ")" + ")";

    }

    public static int addQuestionnaireContent(QuestionnaireContent quesContent) {

        int quesContentId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(QuestionnaireContent.KEY_QUESTIONNAIRE_ID, quesContent.getQuestionnaireId());
        values.put(QuestionnaireContent.KEY_QUESTION_ID, quesContent.getQuestionId());
        values.put(QuestionnaireContent.KEY_QUESTION_ORDER, quesContent.getQuestionOrder());


        quesContentId = (int) db.insert(QuestionnaireContent.TABLE,null,values);

        DatabaseManager.getInstance().closeDatabase();

        return quesContentId;

    }

}
