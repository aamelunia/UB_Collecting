package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.Language;
import edu.buffalo.cse.ubcollecting.data.models.Question;
import edu.buffalo.cse.ubcollecting.data.models.QuestionLangVersion;
import edu.buffalo.cse.ubcollecting.data.models.Questionnaire;
import edu.buffalo.cse.ubcollecting.data.models.QuestionnaireType;

public class QuestionLangVersionTable {

    private QuestionLangVersion questionLangVersion;

    public QuestionLangVersionTable () {

        questionLangVersion = new QuestionLangVersion();

    }

    public static String createTable(){
        return "CREATE TABLE "
                + QuestionLangVersion.TABLE + "(" + QuestionLangVersion.KEY_QUESTION_ID + " TEXT,"
                + QuestionLangVersion.KEY_QUESTION_LANG_ID + " TEXT," + QuestionLangVersion.KEY_QUESTION_TEXT + " VARCHAR,"
                + "PRIMARY KEY("+ QuestionLangVersion.KEY_QUESTION_ID+", "+QuestionLangVersion.KEY_QUESTION_LANG_ID+"),"
                + " FOREIGN KEY(" + QuestionLangVersion.KEY_QUESTION_LANG_ID + ") REFERENCES " + Language.TABLE
                + " (" + Language.KEY_ID + ")," + " FOREIGN KEY(" + QuestionLangVersion.KEY_QUESTION_ID + ") REFERENCES " + Question.TABLE
                + " (" + Question.KEY_ID + ")" + ")";
    }

    public static int addQuestionLangVersion(QuestionLangVersion questionLangVersion) {

        int questionLangVersionId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        ContentValues values = new ContentValues();
        values.put(QuestionLangVersion.KEY_QUESTION_ID, questionLangVersion.getQuestionId());
        values.put(QuestionLangVersion.KEY_QUESTION_LANG_ID, questionLangVersion.getLanguageId());
        values.put(QuestionLangVersion.KEY_QUESTION_TEXT, questionLangVersion.getQuestionText());

        questionLangVersionId = (int) db.insert(QuestionLangVersion.TABLE,null,values);

        DatabaseManager.getInstance().closeDatabase();

        return questionLangVersionId;

    }

}
