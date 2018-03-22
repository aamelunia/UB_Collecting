package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class Answer {

    private static final String TAG = Answer.class.getSimpleName().toString();

    // Table Names
    public static final String TABLE = "Answer";

    // Answer Table - column names
    public static final String KEY_ID = "id";
    public static final String KEY_QUESTIONNAIRE_ID = "QuestionnaireId";
    public static final String KEY_QUESTION_ID = "QuestionId";
    public static final String KEY_ANSWER_LABEL = "AnswerLabel";
    public static final String KEY_ANSWER_TEXT = "AnswerText";


    public String id;
    public String questionnaireId;
    public String questionId;
    public String label;
    public String text;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }









}
