package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.SessionPerson;

public class SessionPersonTable {

    private SessionPerson sessionPerson;

    public SessionPersonTable () {

        sessionPerson = new SessionPerson();

    }

    public static String createTable(){
        //  Add primary key? How about all the foreign keys?!
        return "CREATE TABLE "
                + SessionPerson.TABLE + "(" + SessionPerson.KEY_SESSION_ID + " TEXT," + SessionPerson.KEY_SESSION_PERSON_ID
                + " TEXT," + SessionPerson.KEY_SESSION_PERSON_ROLE_ID + " TEXT" + ")";
    }

    public int addSessionPerson(SessionPerson sessionPerson) {

        int sessionPersonId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(SessionPerson.KEY_SESSION_ID, sessionPerson.getSessionId());
        values.put(SessionPerson.KEY_SESSION_PERSON_ID, sessionPerson.getPersonId());
        values.put(SessionPerson.KEY_SESSION_PERSON_ROLE_ID, sessionPerson.getRoleId());

        sessionPersonId = (int) db.insert(SessionPerson.TABLE,null,values);

        DatabaseManager.getInstance().closeDatabase();

        return sessionPersonId;

    }

}
