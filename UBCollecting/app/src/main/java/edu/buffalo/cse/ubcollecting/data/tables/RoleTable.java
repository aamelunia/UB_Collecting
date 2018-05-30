package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */

import android.util.Log;

import edu.buffalo.cse.ubcollecting.RoleActivity;
import edu.buffalo.cse.ubcollecting.data.models.Role;

public class RoleTable extends Table<Role> {

    public static final String TABLE = "Role";

    // Role Table - column names
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "Name";
    public static final String KEY_INTRO_REQUIRED = "IntroRequired";
    public static final String KEY_PHOTO_REQUIRED = "PhotoRequired";
    public static final String KEY_ON_CLIENT = "OnClient";

    public RoleTable() {
        super();
        activityClass = RoleActivity.class;
    }

    @Override
    public String createTable() {
        Log.i("Role TabLe NAME: ", TABLE);
        return "CREATE TABLE "
                + TABLE + "(" + KEY_ID + " TEXT PRIMARY KEY," + KEY_NAME
                + " VARCHAR," + KEY_INTRO_REQUIRED + " INTEGER," + KEY_PHOTO_REQUIRED
                + " INTEGER," + KEY_ON_CLIENT + " INTEGER" + ")";
    }

    @Override
    public String getTableName() {
        return TABLE;
    }
}
