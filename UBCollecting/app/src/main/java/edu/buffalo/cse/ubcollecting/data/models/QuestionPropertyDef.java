package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class QuestionPropertyDef  {

    private static final String TAG = QuestionPropertyDef.class.getSimpleName().toString();

    public static final String TABLE = "QuestionPropertyDef";

    // QuestionPropertyDef Table - column names
    public static final String KEY_ID = "id";
    public static final String KEY_PROPERTY_NAME = "PropertyName";


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
