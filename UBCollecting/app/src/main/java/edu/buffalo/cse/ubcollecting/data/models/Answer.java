package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class Answer {

    private static final String TAG = Answer.class.getSimpleName().toString();

    // Table Names
    public static final String TABLE = "Answer";

    // Answer Table - column names
    public static final String KEY_ID = "_id";
    public static final String KEY_QUESTIONNAIRE_ID = "QuestionnaireId";
    public static final String KEY_QUESTION_ID = "QuestionId";
    public static final String KEY_ANSWER_LABEL = "AnswerLabel";
    public static final String KEY_ANSWER_TEXT = "AnswerText";


    public int id;
    public int questionnaireId;
    public int questionId;
    public String label;
    public String text;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(int questionnaireId) {
        this.questionnaireId = questionnaireId;
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
