package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.Person;
import edu.buffalo.cse.ubcollecting.data.models.Role;
import edu.buffalo.cse.ubcollecting.data.models.Session;
import edu.buffalo.cse.ubcollecting.data.models.SessionPerson;

public class SessionPersonTable {

    private SessionPerson sessionPerson;

    public SessionPersonTable () {

        sessionPerson = new SessionPerson();

    }

    public static String createTable(){
        return "CREATE TABLE "
                + SessionPerson.TABLE + "(" + SessionPerson.KEY_SESSION_ID + " INTEGER,"
                + " FOREIGN KEY(" + SessionPerson.KEY_SESSION_ID + ") REFERENCES " + Session.TABLE
                + " (" + Session.KEY_ID + "), "+ SessionPerson.KEY_PERSON_ID + " INTEGER,"
                + " FOREIGN KEY(" + SessionPerson.KEY_PERSON_ID + ") REFERENCES " + Person.TABLE
                + " (" + Person.KEY_ID + "), " + SessionPerson.KEY_ROLE_ID + " INTEGER,"
                + " FOREIGN KEY(" + SessionPerson.KEY_ROLE_ID + ") REFERENCES " + Role.TABLE
                + " (" + Role.KEY_ID + ") " + ")";
    }

    public static int addSessionPerson(SessionPerson sessionPerson) {

        int sessionPersonId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(SessionPerson.KEY_SESSION_ID, sessionPerson.getSessionId());
        values.put(SessionPerson.KEY_PERSON_ID, sessionPerson.getPersonId());
        values.put(SessionPerson.KEY_ROLE_ID, sessionPerson.getRoleId());

        sessionPersonId = (int) db.insert(SessionPerson.TABLE,null,values);

        DatabaseManager.getInstance().closeDatabase();

        return sessionPersonId;

    }

}
