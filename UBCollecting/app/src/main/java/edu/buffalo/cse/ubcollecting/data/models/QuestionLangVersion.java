package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class QuestionLangVersion extends Model {

    private static final String TAG = QuestionLangVersion.class.getSimpleName().toString();

    public String questionId;
    public String questionLanguageId;
    public String questionText;


    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestionLanguageId() {
        return questionLanguageId;
    }

    public void setQuestionLanguageId(String questionLanguageId) {
        this.questionLanguageId = questionLanguageId;
    }

    public String getQuestionText() {
        return questionText;
    }

    public void setQuestionText(String questionText) {
        this.questionText = questionText;
    }


}
