package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */

import edu.buffalo.cse.ubcollecting.data.models.Session;

public class SessionTable extends Table<Session> {

    // Table Name
    public static final String TABLE = "Session";

    // Session Table - column names
    public static final String KEY_ID = "id";
    public static final String KEY_LABEL = "Label";
    public static final String KEY_NAME = "Name";
    public static final String KEY_START_TIME = "StartTime";
    public static final String KEY_LOCATION = "Location";
    public static final String KEY_DESCRIPTION = "Description";
    public static final String KEY_FIELD_TRIP_ID = "FieldTripId";

    public SessionTable () {
        super();
    }

    public String createTable(){
        return "CREATE TABLE "
                + TABLE + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_LABEL
                + " VARCHAR," + KEY_NAME + " VARCHAR," + KEY_START_TIME
                + " DATETIME," + KEY_LOCATION + " VARCHAR," + KEY_DESCRIPTION
                + " VARCHAR,"+ KEY_FIELD_TRIP_ID + " TEXT," + " FOREIGN KEY(" + KEY_FIELD_TRIP_ID
                + ") REFERENCES " + FieldTripTable.TABLE + " (" + FieldTripTable.KEY_ID + ")" + ")";
    }

    @Override
    public String getTableName(){
        return TABLE;
    }
//    public static int addSession(Session session) {
//
//        int sessionId;
//
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//        ContentValues values = new ContentValues();
//        values.put(Session.KEY_ID, session.getId());
//        values.put(Session.KEY_LABEL, session.getLabel());
//        values.put(Session.KEY_NAME, session.getName());
//        values.put(Session.KEY_START_TIME, session.getStartTime());
//        values.put(Session.KEY_LOCATION, session.getLocation());
//        values.put(Session.KEY_DESCRIPTION, session.getDescription());
//        values.put(Session.KEY_FIELD_TRIP_ID, session.getFieldTripId());
//
//
//        sessionId = (int) db.insert(Session.TABLE,null,values);
//
//        DatabaseManager.getInstance().closeDatabase();
//
//        return sessionId;
//
//    }

}
