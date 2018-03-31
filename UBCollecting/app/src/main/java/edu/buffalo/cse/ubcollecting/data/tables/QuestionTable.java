package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */

import android.util.Log;

import edu.buffalo.cse.ubcollecting.data.models.Question;

public class QuestionTable extends MainTable<Question> {

    public static final String TABLE = "Question";

    // Question (QuestionPool) Table - column names
    public static final String KEY_ID = "id";
    public static final String KEY_TYPE = "Type";

    public QuestionTable() {
        super();
    }

    @Override
    public String createTable() {
        Log.i("QuestionTable", TABLE);
        return "CREATE TABLE "
                + TABLE + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_TYPE + " VARCHAR" + ")";
    }

    @Override
    public String getTableName() {
        return TABLE;
    }
}
