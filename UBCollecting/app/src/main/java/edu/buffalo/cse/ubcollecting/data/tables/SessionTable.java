package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.FieldTrip;
import edu.buffalo.cse.ubcollecting.data.models.Questionnaire;
import edu.buffalo.cse.ubcollecting.data.models.QuestionnaireType;
import edu.buffalo.cse.ubcollecting.data.models.Session;

public class SessionTable {

    private Session session;

    public SessionTable () {

        session = new Session();

    }

    public static String createTable(){
        return "CREATE TABLE "
                + Session.TABLE + "(" + Session.KEY_ID + " INTEGER PRIMARY KEY," + Session.KEY_SESSION_LABEL
                + " VARCHAR," + Session.KEY_SESSION_NAME + " VARCHAR," + Session.KEY_SESSION_START_TIME
                + " DATETIME," + Session.KEY_SESSION_LOCATION + " VARCHAR," + Session.KEY_SESSION_DESC
                + " VARCHAR,"+ Session.KEY_FIELD_TRIP_ID + " INTEGER," + " FOREIGN KEY(" + Session.KEY_FIELD_TRIP_ID
                + ") REFERENCES " + FieldTrip.TABLE + " (" + FieldTrip.KEY_ID + ")" + ")";
    }

    public static int addSession(Session session) {

        int sessionId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Session.KEY_SESSION_LABEL, session.getLabel());
        values.put(Session.KEY_SESSION_NAME, session.getName());
        values.put(Session.KEY_SESSION_START_TIME, session.getStartTime());
        values.put(Session.KEY_SESSION_LOCATION, session.getLocation());
        values.put(Session.KEY_SESSION_DESC, session.getDescription());
        values.put(Session.KEY_FIELD_TRIP_ID, session.getFieldTripId());


        sessionId = (int) db.insert(Session.TABLE,null,values);

        DatabaseManager.getInstance().closeDatabase();

        return sessionId;

    }

}
