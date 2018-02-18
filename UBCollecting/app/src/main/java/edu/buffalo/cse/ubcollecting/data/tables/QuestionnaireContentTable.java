package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.QuestionnaireContent;

public class QuestionnaireContentTable {

    private QuestionnaireContent questionnaireContent;

    public QuestionnaireContentTable () {

        questionnaireContent = new QuestionnaireContent();

    }

    public static String createTable(){
        // PRIMARY KEY?. NEED TO ADD FOREIGN KEYS?!
        return "CREATE TABLE "
                + QuestionnaireContent.TABLE + "(" + QuestionnaireContent.KEY_QUESTIONNAIRE_ID + " TEXT PRIMARY KEY,"
                + QuestionnaireContent.KEY_QUESTION_ID + " TEXT," + QuestionnaireContent.KEY_QUESTION_ORDER + " VARCHAR"
                + ")";
    }

    public int addQuestionnaireContent(QuestionnaireContent quesContent) {

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