package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import edu.buffalo.cse.ubcollecting.data.models.QuestionProperty;

public class QuestionPropertyTable extends Table<QuestionProperty> {

    public static final String TABLE = "QuestionProperty";

    // QuestionProperty Table - column names
    public static final String KEY_QUESTION_ID = "QuestionId";
    public static final String KEY_PROPERTY_ID = "PropertyId";
    public static final String KEY_VALUE = "Value";

    public QuestionPropertyTable () {
        super();
    }

    @Override
    public String createTable(){
        return "CREATE TABLE "
                + TABLE + "(" + KEY_QUESTION_ID + " TEXT,"
                + KEY_PROPERTY_ID + " TEXT," + KEY_VALUE + " INTEGER,"
                + "PRIMARY KEY(" + KEY_QUESTION_ID + ", " + KEY_PROPERTY_ID + "),"
                + " FOREIGN KEY(" + KEY_PROPERTY_ID + ") REFERENCES " + QuestionPropertyDefTable.TABLE
                + " (" + QuestionPropertyDefTable.KEY_ID + ")," + " FOREIGN KEY(" + KEY_QUESTION_ID + ") REFERENCES "
                + QuestionTable.TABLE + " (" + QuestionTable.KEY_ID + ")" + ")";
    }

    @Override
    public String getTableName(){
        return TABLE;
    }
//    public static int addQuestionProperty(QuestionProperty questionProperty) {
//
//        int questionPropertyId;
//
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(QuestionProperty.KEY_QUESTION_ID, questionProperty.getQuestionId());
//        values.put(QuestionProperty.KEY_PROPERTY_ID, questionProperty.getPropertyId());
//        values.put(QuestionProperty.KEY_VALUE, questionProperty.getValue());
//
//        questionPropertyId = (int) db.insert(QuestionProperty.TABLE,null,values);
//
//        DatabaseManager.getInstance().closeDatabase();
//
//        return questionPropertyId;
//
//    }

}
