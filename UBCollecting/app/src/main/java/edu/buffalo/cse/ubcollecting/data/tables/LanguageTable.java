package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import edu.buffalo.cse.ubcollecting.data.models.Language;

public class LanguageTable extends Table<Language> {

    public static final String TABLE = "Language";

    // Language Table - column names
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "Name";
    public static final String KEY_DESCRIPTION = "Description";
    public static final String KEY_OTHER_NAMES = "OtherNames";
    public static final String KEY_TYPE_ID = "TypeId";

    public LanguageTable () {
        super();
    }

    @Override
    public String createTable(){
        return "CREATE TABLE "
                + TABLE + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME
                + " VARCHAR," + KEY_DESCRIPTION + " VARCHAR," + KEY_OTHER_NAMES
                + " VARCHAR," + KEY_TYPE_ID + " TEXT," + " FOREIGN KEY(" + KEY_TYPE_ID
                + ") REFERENCES " + LanguageTypeTable.TABLE + " (" + LanguageTypeTable.KEY_ID + ")"
                + ")";
    }

    @Override
    public String getTableName(){
        return TABLE;
    }


}
