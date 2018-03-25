package edu.buffalo.cse.ubcollecting.data.tables;

import edu.buffalo.cse.ubcollecting.data.models.SessionPerson;

/**
 * Created by aamel786 on 2/17/18.
 */
public class SessionPersonTable extends Table<SessionPerson> {

    public static final String TABLE = "SessionPerson";

    // SessionPerson Table - column names
    public static final String KEY_SESSION_ID = "SessionId";
    public static final String KEY_PERSON_ID = "PersonId";
    public static final String KEY_ROLE_ID = "RoleId";

    public SessionPersonTable () {
        super();
    }

    public  String createTable(){
        return "CREATE TABLE "
                + TABLE + "(" + KEY_SESSION_ID + " TEXT,"
                + KEY_PERSON_ID + " TEXT," + KEY_ROLE_ID + " TEXT,"
                + "PRIMARY KEY(" + KEY_SESSION_ID + ", " + KEY_PERSON_ID + "),"
                + " FOREIGN KEY(" + KEY_SESSION_ID + ") REFERENCES " + SessionTable.TABLE
                + " (" + SessionTable.KEY_ID + "),"
                + " FOREIGN KEY(" + KEY_PERSON_ID + ") REFERENCES " + PersonTable.TABLE
                + " (" + PersonTable.KEY_ID + "),"
                + " FOREIGN KEY(" + KEY_ROLE_ID + ") REFERENCES " + RoleTable.TABLE
                + " (" + RoleTable.KEY_ID + ")" + ")";
    }

    @Override
    public String getTableName(){
        return TABLE;
    }

//    public static int addSessionPerson(SessionPerson sessionPerson) {
//
//        int sessionPersonId;
//
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//        ContentValues values = new ContentValues();
//        values.put(SessionPerson.KEY_SESSION_ID, sessionPerson.getSessionId());
//        values.put(SessionPerson.KEY_PERSON_ID, sessionPerson.getPersonId());
//        values.put(SessionPerson.KEY_ROLE_ID, sessionPerson.getRoleId());
//
//        sessionPersonId = (int) db.insert(SessionPerson.TABLE,null,values);
//
//        DatabaseManager.getInstance().closeDatabase();
//
//        return sessionPersonId;
//
//    }

}
