package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.Questionnaire;
import edu.buffalo.cse.ubcollecting.data.models.QuestionnaireType;


public class QuestionnaireTable {

    public static final String TABLE = "Questionnaire";

    // Questionnaire Table - column names
    public static final String KEY_ID = "id";
    public static final String KEY_LABEL = "Label";
    public static final String KEY_NAME = "Name";
    public static final String KEY_DESCRIPTION = "Description";
    public static final String KEY_TYPE_ID = "TypeId";

    public QuestionnaireTable () {

    }

    public static String createTable(){

        return "CREATE TABLE "
                + TABLE + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_LABEL
                + " VARCHAR," + KEY_NAME + " VARCHAR," + KEY_DESCRIPTION
                + " VARCHAR," + KEY_TYPE_ID + " TEXT," + " FOREIGN KEY(" + KEY_TYPE_ID
                + ") REFERENCES " + QuestionnaireTypeTable.TABLE + " (" + QuestionnaireTypeTable.KEY_ID + ")"
                + ")";

    }

//    public static int addQuestionnaire(Questionnaire ques) {
//
//        int quesId;
//
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//        ContentValues values = new ContentValues();
//        values.put(Questionnaire.KEY_ID, ques.getId());
//        values.put(Questionnaire.KEY_LABEL, ques.getLabel());
//        values.put(Questionnaire.KEY_NAME, ques.getName());
//        values.put(Questionnaire.KEY_DESCRIPTION, ques.getDescription());
//        values.put(Questionnaire.KEY_TYPE_ID, ques.getTypeId());
//
//        quesId = (int) db.insert(Questionnaire.TABLE,null,values);
//
//        DatabaseManager.getInstance().closeDatabase();
//
//        return quesId;
//
//    }

}
