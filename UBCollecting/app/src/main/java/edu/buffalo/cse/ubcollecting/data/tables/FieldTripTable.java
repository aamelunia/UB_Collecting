package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.FieldTrip;

public class FieldTripTable {

    private FieldTrip fieldTrip;

    public FieldTripTable () {

        fieldTrip = new FieldTrip();

    }

    public static String createTable(){
        //  Added primary key below unlike in original script
        return "CREATE TABLE "
                + FieldTrip.TABLE + "(" + FieldTrip.KEY_FIELD_TRIP_ID + " TEXT PRIMARY KEY," + FieldTrip.KEY_FIELD_TRIP_NAME
                + " VARCHAR," + FieldTrip.KEY_FIELD_TRIP_START+ " DATETIME," + FieldTrip.KEY_FIELD_TRIP_END
                + " DATETIME" + ")";
    }

    public int addFieldTrip(FieldTrip fieldTrip) {

        int fieldTripId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(FieldTrip.KEY_FIELD_TRIP_ID, fieldTrip.getId());
        values.put(FieldTrip.KEY_FIELD_TRIP_NAME, fieldTrip.getName());
        values.put(FieldTrip.KEY_FIELD_TRIP_START, fieldTrip.getStartDate());
        values.put(FieldTrip.KEY_FIELD_TRIP_END, fieldTrip.getEndDate());
        
        fieldTripId = (int) db.insert(FieldTrip.TABLE,null,values);

        DatabaseManager.getInstance().closeDatabase();

        return fieldTripId;

    }

}
