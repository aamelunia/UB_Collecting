package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.QuestionnaireType;

public class QuestionnaireTypeTable extends Table<QuestionnaireType> {

    // QuestionnaireType Table - column names
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "Name";

    public QuestionnaireTypeTable () {
        super();
        TABLE = "QuestionnaireType";
    }

    @Override
    public String createTable(){
        //  Added primary key below unlike in original script
        return "CREATE TABLE "
                + TABLE + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME + " VARCHAR" + ")";
    }

//    public static int addQuestionnaireType(QuestionnaireType quesType) {
//
//        int quesTypeId;
//
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//        ContentValues values = new ContentValues();
//        values.put(QuestionnaireType.KEY_ID, quesType.getId());
//        values.put(QuestionnaireType.KEY_NAME, quesType.getName());
//
//        quesTypeId = (int) db.insert(QuestionnaireType.TABLE,null,values);
//
//        DatabaseManager.getInstance().closeDatabase();
//
//        return quesTypeId;
//
//    }

}
