package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */

import edu.buffalo.cse.ubcollecting.FieldTripActivity;
import edu.buffalo.cse.ubcollecting.data.models.FieldTrip;

public class FieldTripTable extends MainTable<FieldTrip> {

    public static final String TABLE = "FieldTrip";

    // FieldTrip Table - column names
    public static final String KEY_ID = "id";
    public static final String KEY_FIELD_TRIP_NAME = "Name";
    public static final String KEY_START_DATE = "StartDate";
    public static final String KEY_END_DATE = "EndDate";

    public FieldTripTable() {
        super();
        activityClass = FieldTripActivity.class;
    }

    public String createTable() {
        return "CREATE TABLE "
                + TABLE + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_FIELD_TRIP_NAME
                + " VARCHAR," + KEY_START_DATE + " DATETIME," + KEY_END_DATE
                + " DATETIME" + ")";
    }

    @Override
    public String getTableName() {
        return TABLE;
    }
}
