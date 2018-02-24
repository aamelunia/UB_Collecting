package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class QuestionnaireContent  {

    private static final String TAG = QuestionnaireContent.class.getSimpleName().toString();

    // Table Names
    public static final String TABLE = "QuestionnaireContent";

    // QuestionnaireContent Table - column names
    public static final String KEY_QUESTIONNAIRE_ID = "QuestionnaireId";
    public static final String KEY_QUESTION_ID = "QuestionId";
    public static final String KEY_QUESTION_ORDER = "QuestionOrder";


    public int questionnaireId;
    public int questionId;
    public String questionOrder;


    public int getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(int questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestionOrder() {
        return questionOrder;
    }

    public void setQuestionOrder(String questionOrder) {
        this.questionOrder = questionOrder;
    }




}
