package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class QuestionnaireType  {

    private static final String TAG = QuestionnaireType.class.getSimpleName().toString();

    // Table Names
    public static final String TABLE = "QuestionnaireType";

    // QuestionnaireType Table - column names
    public static final String KEY_ID = "id";
    public static final String KEY_TYPE_NAME = "TypeName";

    public String id;
    public String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
