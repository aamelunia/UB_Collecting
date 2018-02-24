package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.QuestionnaireType;

public class QuestionnaireTypeTable {

    private QuestionnaireType questionnaireType;

    public QuestionnaireTypeTable () {

        questionnaireType = new QuestionnaireType();

    }

    public static String createTable(){
        //  Added primary key below unlike in original script
        return "CREATE TABLE "
                + QuestionnaireType.TABLE + "(" + QuestionnaireType.KEY_QUESTIONNAIRE_TYPE_ID + " INTEGER PRIMARY KEY,"
                + QuestionnaireType.KEY_TYPE_NAME + " VARCHAR" + ")";
    }

    public int addQuestionnaireType(QuestionnaireType quesType) {

        int quesTypeId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(QuestionnaireType.KEY_TYPE_NAME, quesType.getName());

        quesTypeId = (int) db.insert(QuestionnaireType.TABLE,null,values);

        DatabaseManager.getInstance().closeDatabase();

        return quesTypeId;

    }

}
