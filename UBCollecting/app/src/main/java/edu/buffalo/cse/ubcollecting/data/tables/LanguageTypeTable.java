package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.LanguageType;

public class LanguageTypeTable extends Table<LanguageType> {

    // LanguageType Table - column names
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "Name";

    public LanguageTypeTable () {
        super();
        TABLE = "LanguageType";
    }

    @Override
    public String createTable(){
        return "CREATE TABLE "
                + TABLE + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME + " VARCHAR" + ")";
    }

//    public static int addLanguageType(LanguageType languageType) {
//
//        int languageTypeId;
//
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(LanguageType.KEY_ID, languageType.getId());
//        values.put(LanguageType.KEY_NAME, languageType.getName());
//
//        languageTypeId = (int) db.insert(LanguageType.TABLE,null,values);
//
//        DatabaseManager.getInstance().closeDatabase();
//
//        return languageTypeId;
//
//    }

}
