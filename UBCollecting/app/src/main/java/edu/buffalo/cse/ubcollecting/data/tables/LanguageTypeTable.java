package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.LanguageType;

public class LanguageTypeTable {

    private LanguageType languageType;

    public LanguageTypeTable () {

        languageType = new LanguageType();

    }

    public static String createTable(){
        //  Added primary key below unlike in original script
        return "CREATE TABLE "
                + LanguageType.TABLE + "(" + LanguageType.KEY_LANG_TYPE_ID + " TEXT," + LanguageType.KEY_LANG_TYPE_NAME
                + " VARCHAR" + ")";
    }

    public int addLanguageType(LanguageType languageType) {

        int languageTypeId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        ContentValues values = new ContentValues();
        values.put(LanguageType.KEY_LANG_TYPE_ID, languageType.getId());
        values.put(LanguageType.KEY_LANG_TYPE_NAME, languageType.getName());

        languageTypeId = (int) db.insert(LanguageType.TABLE,null,values);

        DatabaseManager.getInstance().closeDatabase();

        return languageTypeId;

    }

}
