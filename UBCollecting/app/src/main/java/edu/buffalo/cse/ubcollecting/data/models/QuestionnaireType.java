package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class QuestionnaireType  {

    private static final String TAG = QuestionnaireType.class.getSimpleName().toString();

    // Table Names
    public static final String TABLE = "QuestionnaireType";

    // QuestionnaireType Table - column names
    public static final String KEY_TYPE_NAME = "TypeName";

    public String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }


}
