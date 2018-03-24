package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.Language;
import edu.buffalo.cse.ubcollecting.data.models.Question;
import edu.buffalo.cse.ubcollecting.data.models.QuestionOption;

public class QuestionOptionTable {


    public static final String TABLE = "QuestionOption";

    // QuestionOption Table - column names
    public static final String KEY_QUESTION_ID = "QuestionId";
    public static final String KEY_QUESTION_LANGUAGE_ID = "QuestionLanguageId";
    public static final String KEY_OPTION_TEXT = "OptionText";

    public QuestionOptionTable () {

    }

    public static String createTable(){
        return "CREATE TABLE "
                + TABLE + "(" + KEY_QUESTION_ID + " TEXT,"
                + KEY_QUESTION_LANGUAGE_ID + " TEXT," + KEY_OPTION_TEXT + " VARCHAR,"
                + "PRIMARY KEY(" + KEY_QUESTION_ID + ", " + KEY_QUESTION_LANGUAGE_ID + "),"
                + " FOREIGN KEY(" + KEY_QUESTION_LANGUAGE_ID + ") REFERENCES " + LanguageTable.TABLE
                + " (" + LanguageTable.KEY_ID + ")," + " FOREIGN KEY(" + KEY_QUESTION_ID + ") REFERENCES "
                + QuestionTable.TABLE + " (" + QuestionTable.KEY_ID + ")"  + ")";
    }

//    public static int addQuestionOption(QuestionOption questionOption) {
//
//        int questionOptionId;
//
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(QuestionOption.KEY_QUESTION_ID, questionOption.getQuestionId());
//        values.put(QuestionOption.KEY_QUESTION_LANGUAGE_ID, questionOption.getQuestionLanguageId());
//        values.put(QuestionOption.KEY_OPTION_TEXT, questionOption.getOptionText());
//
//        questionOptionId = (int) db.insert(QuestionOption.TABLE,null,values);
//
//        DatabaseManager.getInstance().closeDatabase();
//
//        return questionOptionId;
//
//    }

}
