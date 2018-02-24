package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class Session {

    private static final String TAG = Session.class.getSimpleName().toString();

    // Table Names
    public static final String TABLE = "Session";

    // Session Table - column names
    public static final String KEY_SESSION_ID = "SessionId";
    public static final String KEY_SESSION_LABEL = "SessionLabel";
    public static final String KEY_SESSION_NAME = "SessionName";
    public static final String KEY_SESSION_START_TIME = "SessionStartTime";
    public static final String KEY_SESSION_LOCATION = "SessionLocation";
    public static final String KEY_SESSION_DESC = "SessionDesc";
    public static final String KEY_FIELD_TRIP_ID = "FieldTripId";



    //  Need to appropriately configure type for start time
    public String id;
    public String label;
    public String name;
    public String startTime;
    public String location;
    public String description;
    public String fieldTripId;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFieldTripId() {
        return fieldTripId;
    }

    public void setFieldTripId(String fieldTripId) {
        this.fieldTripId = fieldTripId;
    }



}
