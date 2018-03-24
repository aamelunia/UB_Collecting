package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.Language;
import edu.buffalo.cse.ubcollecting.data.models.LanguageType;

public class LanguageTable {

    // Table Name
    public static final String TABLE = "Language";

    // Language Table - column names
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "Name";
    public static final String KEY_DESCRIPTION = "Description";
    public static final String KEY_OTHER_NAMES = "OtherNames";
    public static final String KEY_TYPE_ID = "TypeId";

    public LanguageTable () {

    }

    public static String createTable(){
        return "CREATE TABLE "
                + TABLE + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME
                + " VARCHAR," + KEY_DESCRIPTION + " VARCHAR," + KEY_OTHER_NAMES
                + " VARCHAR," + KEY_TYPE_ID + " TEXT," + " FOREIGN KEY(" + KEY_TYPE_ID
                + ") REFERENCES " + LanguageTypeTable.TABLE + " (" + LanguageTypeTable.KEY_ID + ")"
                + ")";
    }


//    public static int addLanguage(Language language) {
//
//        int langId;
//
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(Language.KEY_ID, language.getName());
//        values.put(Language.KEY_NAME, language.getName());
//        values.put(Language.KEY_DESCRIPTION, language.getDescription());
//        values.put(Language.KEY_OTHER_NAMES, language.getOtherNames());
//        values.put(Language.KEY_TYPE_ID, language.getTypeId());
//
//        langId = (int) db.insert(Language.TABLE,null,values);
//
//        DatabaseManager.getInstance().closeDatabase();
//
//        return langId;
//
//    }

}
