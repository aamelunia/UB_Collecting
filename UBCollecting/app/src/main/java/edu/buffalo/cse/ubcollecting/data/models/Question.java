package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class Question  {

    private static final String TAG = Question.class.getSimpleName().toString();

    // Table Names
    public static final String TABLE = "Question";

    // Question (QuestionPool) Table - column names
    public static final String KEY_ID = "_id";
    public static final String KEY_QUESTION_TYPE = "QuestionType";



    public int id;
    public String type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }





}
