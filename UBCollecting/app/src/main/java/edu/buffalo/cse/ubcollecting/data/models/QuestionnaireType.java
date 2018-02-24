package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class QuestionnaireType  {

    private static final String TAG = QuestionnaireType.class.getSimpleName().toString();

    // Table Names
    public static final String TABLE = "QuestionnaireType";

    // QuestionnaireType Table - column names
    public static final String KEY_QUESTIONNAIRE_TYPE_ID = "_id";
    public static final String KEY_TYPE_NAME = "TypeName";

    public int id;
    public String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setTypeName(String name) {
        this.name = name;
    }


}
