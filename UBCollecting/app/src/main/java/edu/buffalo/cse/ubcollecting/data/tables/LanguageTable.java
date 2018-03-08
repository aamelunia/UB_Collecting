package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.Language;
import edu.buffalo.cse.ubcollecting.data.models.LanguageType;
import edu.buffalo.cse.ubcollecting.data.models.Questionnaire;
import edu.buffalo.cse.ubcollecting.data.models.QuestionnaireType;

public class LanguageTable {

    private Language language;

    public LanguageTable () {

        language = new Language();

    }

    public static String createTable(){
        return "CREATE TABLE "
                + Language.TABLE + "(" + Language.KEY_ID + " INTEGER PRIMARY KEY," + Language.KEY_LANG_NAME
                + " VARCHAR," + Language.KEY_LANG_DESC + " VARCHAR," + Language.KEY_LANG_OTHER_NAMES
                + " VARCHAR," + Language.KEY_LANG_TYPE_ID + " INTEGER," + " FOREIGN KEY(" + Language.KEY_LANG_TYPE_ID
                + ") REFERENCES " + LanguageType.TABLE + " (" + LanguageType.KEY_ID + ")" + ")";
    }

    public static int addLanguage(Language language) {

        int langId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        ContentValues values = new ContentValues();
        values.put(Language.KEY_LANG_NAME, language.getName());
        values.put(Language.KEY_LANG_DESC, language.getDescription());
        values.put(Language.KEY_LANG_OTHER_NAMES, language.getOtherNames());
        values.put(Language.KEY_LANG_TYPE_ID, language.getTypeId());

        langId = (int) db.insert(Language.TABLE,null,values);

        DatabaseManager.getInstance().closeDatabase();

        return langId;

    }

}
