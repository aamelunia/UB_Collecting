package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class LanguageType  {

    private static final String TAG = LanguageType.class.getSimpleName().toString();

    // Table Names
    public static final String TABLE = "LanguageType";

    // LanguageType Table - column names
    public static final String KEY_ID = "_id";
    public static final String KEY_LANG_TYPE_NAME = "LangTypeName";


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

    public void setName(String name) {
        this.name = name;
    }



}
