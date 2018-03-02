package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class SessionAnswer {

    private static final String TAG = SessionAnswer.class.getSimpleName().toString();

    // Table Names
    public static final String TABLE = "SessionAnswer";

    // SessionAnswer Table - column names
    public static final String KEY_SESSION_ID = "SessionId";
    public static final String KEY_QUESTIONNAIRE_ID = "QuestionnaireId";
    public static final String KEY_QUESTION_ID = "QuestionId";
    public static final String KEY_ANSWER_ID = "AnswerId";

    public int sessionId;
    public int questionnaireId;
    public int questionId;
    public int answerId;

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

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

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }


}
