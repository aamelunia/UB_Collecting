package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.Session;

public class SessionTable {

    private Session session;

    public SessionTable () {

        session = new Session();

    }

    public static String createTable(){
        //  Added primary key below unlike in original script
        return "CREATE TABLE "
                + Session.TABLE + "(" + Session.KEY_SESSION_ID + " TEXT PRIMARY KEY," + Session.KEY_SESSION_LABEL
                + " VARCHAR," + Session.KEY_SESSION_NAME + " VARCHAR," + Session.KEY_SESSION_START_TIME
                + " DATETIME," + Session.KEY_SESSION_LOCATION + " VARCHAR," + Session.KEY_SESSION_DESC
                + " VARCHAR"+ ")";
    }

    public int addSession(Session session) {

        int sessionId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Session.KEY_SESSION_ID, session.getId());
        values.put(Session.KEY_SESSION_LABEL, session.getLabel());
        values.put(Session.KEY_SESSION_NAME, session.getName());
        values.put(Session.KEY_SESSION_START_TIME, session.getStartTime());
        values.put(Session.KEY_SESSION_LOCATION, session.getLocation());
        values.put(Session.KEY_SESSION_DESC, session.getDescription());

        sessionId = (int) db.insert(Session.TABLE,null,values);

        DatabaseManager.getInstance().closeDatabase();

        return sessionId;

    }

}
