package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class QuestionProperty  {

    private static final String TAG = QuestionProperty.class.getSimpleName().toString();

    // Table Names
    public static final String TABLE = "QuestionProperty";

    // QuestionProperty Table - column names
    public static final String KEY_QUESTION_ID = "QuestionId";
    public static final String KEY_QUESTION_PROPERTY_ID = "QuestionPropertyId";
    public static final String KEY_QUESTION_PROPERTY_VALUE = "QuestionPropertyValue";



    public String questionId;
    public String propertyId;
    public int value;

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(String propertyId) {
        this.propertyId = propertyId;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }





}
