package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.FieldTrip;

public class FieldTripTable extends Table<FieldTrip> {

    // FieldTrip Table - column names
    public static final String KEY_ID = "id";
    public static final String KEY_FIELD_TRIP_NAME = "Name";
    public static final String KEY_START_DATE = "StartDate";
    public static final String KEY_END_DATE = "EndDate";

    public FieldTripTable () {
        super();
        TABLE = "FieldTrip";
    }

    public String createTable(){
        return "CREATE TABLE "
                + TABLE + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_FIELD_TRIP_NAME
                + " VARCHAR," + KEY_START_DATE + " DATETIME," + KEY_END_DATE
                + " DATETIME" + ")";
    }

//    public static int addFieldTrip(FieldTrip fieldTrip) {
//
//        int fieldTripId;
//
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//
//        ContentValues values = new ContentValues();
//        values.put(FieldTrip.KEY_ID, fieldTrip.getId());
//        values.put(FieldTrip.KEY_FIELD_TRIP_NAME, fieldTrip.getName());
//        values.put(FieldTrip.KEY_START_DATE, fieldTrip.getStartDate());
//        values.put(FieldTrip.KEY_END_DATE, fieldTrip.getEndDate());
//
//        fieldTripId = (int) db.insert(FieldTrip.TABLE,null,values);
//
//        DatabaseManager.getInstance().closeDatabase();
//
//        return fieldTripId;
//
//    }

}
