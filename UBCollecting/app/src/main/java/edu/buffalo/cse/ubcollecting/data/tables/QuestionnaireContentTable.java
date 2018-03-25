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

public class QuestionnaireContentTable extends Table<QuestionnaireContent> {

    // QuestionnaireContent Table - column names
    public static final String KEY_QUESTIONNAIRE_ID = "QuestionnaireId";
    public static final String KEY_QUESTION_ID = "QuestionId";
    public static final String KEY_QUESTION_ORDER = "QuestionOrder";

    public QuestionnaireContentTable () {
        super();
        TABLE = "QuestionnaireContent";
    }

    @Override
    public String createTable(){
        return "CREATE TABLE "
                + TABLE + "(" + KEY_QUESTIONNAIRE_ID + " TEXT,"
                + KEY_QUESTION_ID + " TEXT," + KEY_QUESTION_ORDER + " VARCHAR,"
                + "PRIMARY KEY(" + KEY_QUESTIONNAIRE_ID + ", " + KEY_QUESTION_ID + "),"
                + " FOREIGN KEY(" + KEY_QUESTION_ID + ") REFERENCES " + QuestionTable.TABLE
                + " (" + QuestionTable.KEY_ID + ")," + " FOREIGN KEY(" + KEY_QUESTIONNAIRE_ID
                + ") REFERENCES " + QuestionnaireTable.TABLE + " (" + QuestionnaireTable.KEY_ID + ")"
                + ")";

    }

//    public static int addQuestionnaireContent(QuestionnaireContent quesContent) {
//
//        int quesContentId;
//
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//        ContentValues values = new ContentValues();
//        values.put(QuestionnaireContent.KEY_QUESTIONNAIRE_ID, quesContent.getQuestionnaireId());
//        values.put(QuestionnaireContent.KEY_QUESTION_ID, quesContent.getQuestionId());
//        values.put(QuestionnaireContent.KEY_QUESTION_ORDER, quesContent.getQuestionOrder());
//
//
//        quesContentId = (int) db.insert(QuestionnaireContent.TABLE,null,values);
//
//        DatabaseManager.getInstance().closeDatabase();
//
//        return quesContentId;
//
//    }

}
