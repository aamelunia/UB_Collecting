package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class Language  {

    private static final String TAG = Language.class.getSimpleName().toString();

    // Table Names
    public static final String TABLE = "Language";

    // Language Table - column names
    public static final String KEY_ID = "id";
    public static final String KEY_LANG_NAME = "LanguageName";
    public static final String KEY_LANG_DESC = "LanguageDescription";
    public static final String KEY_LANG_OTHER_NAMES = "LanguageOtherNames";
    public static final String KEY_LANG_TYPE_ID = "LanguageTypeId";

    public String id;
    public String name;
    public String description;
    public String otherNames;
    public String typeId;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }



}
