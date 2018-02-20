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


    // WHY IS QUESTIONTEXT PART OF THIS CLASS?!
    public String questionId;
    public String languageId;
    public String questionText;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getLanguageId() {
        return languageId;
    }

    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }






}
