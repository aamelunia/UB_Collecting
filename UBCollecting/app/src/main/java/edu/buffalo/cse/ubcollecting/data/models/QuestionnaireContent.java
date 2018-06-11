package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class QuestionnaireContent extends Model implements Comparable<QuestionnaireContent> {

    private static final String TAG = QuestionnaireContent.class.getSimpleName().toString();

    public String questionnaireId;
    public String questionId;
    public int questionOrder;

    public String getIdentifier() {
        //TODO
        return "QUESTIONNAIRE CONTENT";
    }

    public String getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(String questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public int getQuestionOrder() {
        return questionOrder;
    }

    public void setQuestionOrder(int questionOrder) {
        this.questionOrder = questionOrder;
    }

    @Override
    public int compareTo(QuestionnaireContent other) {
        return Integer.compare(questionOrder, other.getQuestionOrder());
    }
}
