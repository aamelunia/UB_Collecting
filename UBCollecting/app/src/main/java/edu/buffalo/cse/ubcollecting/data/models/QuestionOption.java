package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class QuestionOption  {

    private static final String TAG = QuestionOption.class.getSimpleName().toString();

    // Table Names
    public static final String TABLE = "QuestionOption";

    // QuestionOption Table - column names
    public static final String KEY_QUESTION_ID = "QuestionId";
    public static final String KEY_QUESTION_LANG_ID = "QuestionLangId";
    public static final String KEY_OPTION_TEXT = "OptionText";



    public int questionId;
    public int languageId;
    public String optionText;

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

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }




}
