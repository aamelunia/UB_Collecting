package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.Role;

public class RoleTable {

    private Role role;

    public RoleTable () {

        role = new Role();

    }

    public static String createTable(){
        //  Added primary key below unlike in original script
        return "CREATE TABLE "
                + Role.TABLE + "(" + Role.KEY_ROLE_ID + " TEXT PRIMARY KEY," + Role.KEY_ROLE_NAME
                + " VARCHAR," + Role.KEY_ROLE_INTRO_REQUIRED + " INTEGER," + Role.KEY_ROLE_PHOTO_REQUIRED
                + " INTEGER," + Role.KEY_ROLE_ON_CLIENT + " INTEGER" + ")";
    }

    public int addRole(Role role) {

        int roleId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        ContentValues values = new ContentValues();
        values.put(Role.KEY_ROLE_ID,role.getId());
        values.put(Role.KEY_ROLE_NAME,role.getName());
        values.put(Role.KEY_ROLE_INTRO_REQUIRED,role.getIntroRequired());
        values.put(Role.KEY_ROLE_PHOTO_REQUIRED,role.getPhotoRequired());
        values.put(Role.KEY_ROLE_ON_CLIENT,role.getOnClient());


        roleId = (int) db.insert(Role.TABLE,null,values);

        DatabaseManager.getInstance().closeDatabase();

        return roleId;

    }

}
