package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class FieldTripSession  {

    private static final String TAG = FieldTripSession.class.getSimpleName().toString();

    // Table Names
    public static final String TABLE = "FieldTripSession";

    // FieldTripSession Table - column names
    public static final String KEY_FIELD_TRIP_ID = "FieldTripId";
    public static final String KEY_SESSION_ID= "SessionId";


    public String fieldTripId;
    public String sessionId;

    public String getFieldTripId() {
        return fieldTripId;
    }

    public void setFieldTripId(String fieldTripId) {
        this.fieldTripId = fieldTripId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }



}
