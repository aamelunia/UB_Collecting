package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.QuestionOption;

public class QuestionOptionTable {

    private QuestionOption questionOption;

    public QuestionOptionTable () {

        questionOption = new QuestionOption();

    }

    public static String createTable(){
    //  Foreign keys?! SHOULD THEY ALL BE TYPE VARCHAR?!
        return "CREATE TABLE "
                + QuestionOption.TABLE + "(" + QuestionOption.KEY_QUESTION_ID + " VARCHAR," + QuestionOption.KEY_QUESTION_LANG_ID
                + " VARCHAR," + QuestionOption.KEY_OPTION_TEXT + " VARCHAR"+ ")";
    }

    public int addQuestionOption(QuestionOption questionOption) {

        int questionOptionId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        ContentValues values = new ContentValues();
        values.put(QuestionOption.KEY_QUESTION_ID, questionOption.getQuestionId());
        values.put(QuestionOption.KEY_QUESTION_LANG_ID, questionOption.getLanguageId());
        values.put(QuestionOption.KEY_OPTION_TEXT, questionOption.getOptionText());

        questionOptionId = (int) db.insert(QuestionOption.TABLE,null,values);

        DatabaseManager.getInstance().closeDatabase();

        return questionOptionId;

    }

}
