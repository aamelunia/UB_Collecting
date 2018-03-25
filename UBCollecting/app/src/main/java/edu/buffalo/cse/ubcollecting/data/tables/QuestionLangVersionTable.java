package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import edu.buffalo.cse.ubcollecting.data.models.QuestionLangVersion;

public class QuestionLangVersionTable extends Table<QuestionLangVersion> {

    public static final String TABLE = "QuestionLangVersion";

    // QuestionLangVersion Table - column names
    public static final String KEY_QUESTION_ID = "QuestionId";
    public static final String KEY_QUESTION_LANG_ID = "QuestionLanguageId";
    public static final String KEY_QUESTION_TEXT = "QuestionText";


    public QuestionLangVersionTable () {
        super();
    }

    @Override
    public String createTable(){
        return "CREATE TABLE "
                + TABLE + "(" + KEY_QUESTION_ID + " TEXT,"
                + KEY_QUESTION_LANG_ID + " TEXT," + KEY_QUESTION_TEXT + " VARCHAR,"
                + "PRIMARY KEY(" + KEY_QUESTION_ID + ", " + KEY_QUESTION_LANG_ID + "),"
                + " FOREIGN KEY(" + KEY_QUESTION_LANG_ID + ") REFERENCES " + LanguageTable.TABLE
                + " (" + LanguageTable.KEY_ID + ")," + " FOREIGN KEY(" + KEY_QUESTION_ID + ") REFERENCES " + QuestionTable.TABLE
                + " (" + QuestionTable.KEY_ID + ")" + ")";
    }

    @Override
    public String getTableName(){
        return TABLE;
    }

//    public static int addQuestionLangVersion(QuestionLangVersion questionLangVersion) {
//
//        int questionLangVersionId;
//
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(QuestionLangVersion.KEY_QUESTION_ID, questionLangVersion.getQuestionId());
//        values.put(QuestionLangVersion.KEY_QUESTION_LANGUAGE_ID, questionLangVersion.getQuestionLanguageId());
//        values.put(QuestionLangVersion.KEY_QUESTION_TEXT, questionLangVersion.getQuestionText());
//
//        questionLangVersionId = (int) db.insert(QuestionLangVersion.TABLE,null,values);
//
//        DatabaseManager.getInstance().closeDatabase();
//
//        return questionLangVersionId;
//
//    }

}
