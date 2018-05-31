package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */

import java.util.ArrayList;
import java.util.HashMap;

import edu.buffalo.cse.ubcollecting.QuestionLangVersionActivity;
import edu.buffalo.cse.ubcollecting.data.DatabaseHelper;
import edu.buffalo.cse.ubcollecting.data.models.Language;
import edu.buffalo.cse.ubcollecting.data.models.QuestionLangVersion;

public class QuestionLangVersionTable extends Table<QuestionLangVersion> {

    public static final String TABLE = "QuestionLangVersion";

    // QuestionLangVersion Table - column names
    public static final String KEY_ID = "id";
    public static final String KEY_QUESTION_ID = "QuestionId";
    public static final String KEY_QUESTION_LANG_ID = "QuestionLanguageId";
    public static final String KEY_QUESTION_TEXT = "QuestionText";


    public QuestionLangVersionTable() {
        super();
        activityClass = QuestionLangVersionActivity.class;
    }

    @Override
    public String createTable() {
        return "CREATE TABLE "
                + TABLE + "(" + KEY_ID + " TEXT, " + KEY_QUESTION_ID + " TEXT, "
                + KEY_QUESTION_LANG_ID + " TEXT," + KEY_QUESTION_TEXT + " VARCHAR,"
                + "PRIMARY KEY(" + KEY_QUESTION_ID + ", " + KEY_QUESTION_LANG_ID + "),"
                + " FOREIGN KEY(" + KEY_QUESTION_LANG_ID + ") REFERENCES " + LanguageTable.TABLE
                + " (" + LanguageTable.KEY_ID + ")," + " FOREIGN KEY(" + KEY_QUESTION_ID + ") REFERENCES " + QuestionTable.TABLE
                + " (" + QuestionTable.KEY_ID + ")" + ")";
    }

    @Override
    public String getTableName() {
        return TABLE;
    }


    public HashMap<Language,QuestionLangVersion> getQuestionTexts(String quesId){

        String selection = KEY_QUESTION_ID + " = ?";

        String[] selectionArgs = {quesId};

        ArrayList<QuestionLangVersion> questionTexts = DatabaseHelper.QUESTION_LANG_VERSION_TABLE.getAll(selection, selectionArgs);

        HashMap<Language,QuestionLangVersion > questions = new HashMap<>();

        for (QuestionLangVersion question: questionTexts){

            Language lang = DatabaseHelper.LANGUAGE_TABLE.findById(question.getQuestionLanguageId());

            questions.put(lang,question);
        }

        return questions;

    }


    /* Function that returns the english text of the question represented by the passed in quesId*/

//    public String getEnglishQuestion(String quesId) {
//
//        String englishId = DatabaseHelper.LANGUAGE_TABLE.getEnglishId();
//
//        String englishQuestion = null;
//
//        String selectQuery = "SELECT QuestionText FROM " + this.getTableName() + " WHERE QuestionId = " + quesId + " and QuestionLanguageId = " + englishId;
//
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//
//        Cursor cursor = db.rawQuery(selectQuery, null);
//
//        if (cursor.moveToFirst()) {
//
//            englishQuestion = cursor.getString(0);
//
//        }
//
//        cursor.close();
//
//        DatabaseManager.getInstance().closeDatabase();
//
//        return englishQuestion;
//
//    }
}
