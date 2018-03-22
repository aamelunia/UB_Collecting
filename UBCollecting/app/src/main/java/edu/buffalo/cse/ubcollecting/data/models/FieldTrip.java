package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class FieldTrip  {

    private static final String TAG = FieldTrip.class.getSimpleName().toString();

    // Table Names
    public static final String TABLE = "FieldTrip";

    // FieldTrip Table - column names
    public static final String KEY_ID = "id";
    public static final String KEY_FIELD_TRIP_NAME = "FieldTripName";
    public static final String KEY_FIELD_TRIP_START = "FieldTripStartDate";
    public static final String KEY_FIELD_TRIP_END = "FieldTripEndDate";

    // Fix types for start/end dates?!
    public String id;
    public String name;
    public String startDate;
    public String endDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }


}
