package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class QuestionLangVersion  {

    private static final String TAG = QuestionLangVersion.class.getSimpleName().toString();

    // Table Names
    public static final String TABLE = "QuestionLangVersion";

    // QuestionLangVersion Table - column names
    public static final String KEY_QUESTION_ID = "QuestionId";
    public static final String KEY_QUESTION_LANG_ID = "QuestionLangId";
    public static final String KEY_QUESTION_TEXT = "QuestionText";


    public int questionId;
    public int languageId;
    public String questionText;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getLanguageId() {
        return languageId;
    }

    public void setLanguageId(int languageId) {
        this.languageId = languageId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }






}
