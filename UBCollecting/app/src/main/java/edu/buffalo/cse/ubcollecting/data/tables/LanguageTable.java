package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */

import java.util.ArrayList;

import edu.buffalo.cse.ubcollecting.LanguageActivity;
import edu.buffalo.cse.ubcollecting.data.DatabaseHelper;
import edu.buffalo.cse.ubcollecting.data.models.Language;
import edu.buffalo.cse.ubcollecting.data.models.LanguageType;

public class LanguageTable extends MainTable<Language> {

    public static final String TABLE = "Language";

    // Language Table - column names
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "Name";
    public static final String KEY_DESCRIPTION = "Description";
    public static final String KEY_OTHER_NAMES = "OtherNames";
    public static final String KEY_TYPE_ID = "TypeId";

    public LanguageTable() {
        super();
        activityClass = LanguageActivity.class;
    }

    @Override
    public String createTable() {
        return "CREATE TABLE "
                + TABLE + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME
                + " VARCHAR," + KEY_DESCRIPTION + " VARCHAR," + KEY_OTHER_NAMES
                + " VARCHAR," + KEY_TYPE_ID + " TEXT," + " FOREIGN KEY(" + KEY_TYPE_ID
                + ") REFERENCES " + LanguageTypeTable.TABLE + " (" + LanguageTypeTable.KEY_ID + ")"
                + ")";
    }

    @Override
    public String getTableName() {
        return TABLE;
    }


    /* Function that returns the research languages stored in the databse (i.e. the languages that
       questions can be written )*/

    public static ArrayList<Language> getResearchLanguages(){

        String selection = LanguageTypeTable.KEY_NAME + " = ?";

        String[] selectionArgs = {"Research Language"};

        ArrayList<LanguageType> languageTypes = DatabaseHelper.LANGUAGE_TYPE_TABLE.getAll(selection, selectionArgs);

        String researchLanguageId = languageTypes.get(0).getId();

        String selection1 = KEY_TYPE_ID + " = ?";

        String [] selectionArgs1 = {researchLanguageId};

        return DatabaseHelper.LANGUAGE_TABLE.getAll(selection1, selectionArgs1);

    }



}
