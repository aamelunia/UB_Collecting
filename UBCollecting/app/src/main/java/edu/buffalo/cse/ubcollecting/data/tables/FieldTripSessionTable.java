package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.FieldTripSession;

public class FieldTripSessionTable {

    private FieldTripSession fieldTripSession;

    public FieldTripSessionTable () {

        fieldTripSession = new FieldTripSession();

    }

    public static String createTable(){
        //  Added primary key below unlike in original script
        return "CREATE TABLE "
                + FieldTripSession.TABLE + "(" + FieldTripSession.KEY_FIELD_TRIP_ID + " TEXT," + FieldTripSession.KEY_SESSION_ID
                + " TEXT" + ")";
    }

    public int addFieldTripSession(FieldTripSession fieldTripSession) {

        int fieldTripSessionId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        ContentValues values = new ContentValues();
        values.put(FieldTripSession.KEY_FIELD_TRIP_ID, fieldTripSession.getFieldTripId());
        values.put(FieldTripSession.KEY_SESSION_ID, fieldTripSession.getSessionId());

        fieldTripSessionId = (int) db.insert(FieldTripSession.TABLE,null,values);

        DatabaseManager.getInstance().closeDatabase();

        return fieldTripSessionId;

    }

}
