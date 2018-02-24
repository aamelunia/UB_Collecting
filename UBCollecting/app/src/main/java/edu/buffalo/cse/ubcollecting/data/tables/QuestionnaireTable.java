package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.Questionnaire;
import edu.buffalo.cse.ubcollecting.data.models.QuestionnaireType;


public class QuestionnaireTable {

    private Questionnaire questionnaire;

    public QuestionnaireTable () {

        questionnaire = new Questionnaire();

    }

    public static String createTable(){

        return "CREATE TABLE "
                + Questionnaire.TABLE + "(" + Questionnaire.KEY_QUES_ID + " INTEGER PRIMARY KEY," + Questionnaire.KEY_QUES_LABEL
                + " VARCHAR," + Questionnaire.KEY_QUES_NAME + " VARCHAR," + Questionnaire.KEY_QUES_DESCRIPTION
                + " VARCHAR," + Questionnaire.KEY_QUES_TYPE_ID + " INTEGER," + " FOREIGN KEY(" + Questionnaire.KEY_QUES_TYPE_ID
                + ") REFERENCES " + QuestionnaireType.TABLE + " (" + QuestionnaireType.KEY_QUESTIONNAIRE_TYPE_ID + ") " + ")";

    }

    public int addQuestionnaire(Questionnaire ques) {

        int quesId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Questionnaire.KEY_QUES_LABEL, ques.getLabel());
        values.put(Questionnaire.KEY_QUES_NAME, ques.getName());
        values.put(Questionnaire.KEY_QUES_DESCRIPTION, ques.getDescription());
        values.put(Questionnaire.KEY_QUES_TYPE_ID, ques.getTypeId());

        quesId = (int) db.insert(Questionnaire.TABLE,null,values);

        DatabaseManager.getInstance().closeDatabase();

        return quesId;

    }

}
