package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.Role;

public class RoleTable {

    private Role role;

    public RoleTable () {

        role = new Role();

    }

    public static String createTable(){
        return "CREATE TABLE "
                + Role.TABLE + "(" + Role.KEY_ID + " INTEGER PRIMARY KEY," + Role.KEY_ROLE_NAME
                + " VARCHAR," + Role.KEY_ROLE_INTRO_REQUIRED + " INTEGER," + Role.KEY_ROLE_PHOTO_REQUIRED
                + " INTEGER," + Role.KEY_ROLE_ON_CLIENT + " INTEGER" + ")";
    }

    public static int addRole(Role role) {

        int roleId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        ContentValues values = new ContentValues();
        values.put(Role.KEY_ROLE_NAME,role.getName());
        values.put(Role.KEY_ROLE_INTRO_REQUIRED,role.getIntroRequired());
        values.put(Role.KEY_ROLE_PHOTO_REQUIRED,role.getPhotoRequired());
        values.put(Role.KEY_ROLE_ON_CLIENT,role.getOnClient());


        roleId = (int) db.insert(Role.TABLE,null,values);

        DatabaseManager.getInstance().closeDatabase();

        return roleId;

    }

    public static Role findById(int id){

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        String[] projection = {
                Role.KEY_ID,
                Role.KEY_ROLE_NAME,
                Role.KEY_ROLE_INTRO_REQUIRED,
                Role.KEY_ROLE_PHOTO_REQUIRED,
                Role.KEY_ROLE_ON_CLIENT,
        };

        String selection = Role.KEY_ID + " = ?";
        String [] selectionArgs = { String.valueOf(id) };

        Cursor cursor = db.query(
                Role.TABLE,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );


        if (cursor != null){
            cursor.moveToFirst();
        }

        Role role = new Role();
        role.setId(Integer.parseInt(cursor.getString(0)));
        role.setName(cursor.getString(1));
        role.setIntroRequired(Integer.parseInt(cursor.getString(2)));
        role.setPhotoRequired(Integer.parseInt(cursor.getString(3)));
        role.setOnClient(Integer.parseInt(cursor.getString(4)));

        cursor.close();

        DatabaseManager.getInstance().closeDatabase();


        return role;

    }

    public static ArrayList<Role> getAllRoles() {
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + Role.TABLE, null);
        ArrayList<Role> list = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                int id = Integer.valueOf(cursor.getString(cursor.getColumnIndex(Role.KEY_ID)));
                String name = cursor.getString(cursor.getColumnIndex(Role.KEY_ROLE_NAME));
                int introRequired = Integer.valueOf(cursor.getString(cursor.getColumnIndex(Role.KEY_ROLE_INTRO_REQUIRED)));
                int photoRequired = Integer.valueOf(cursor.getString(cursor.getColumnIndex(Role.KEY_ROLE_PHOTO_REQUIRED)));
                int onClientRequired = Integer.valueOf(cursor.getString(cursor.getColumnIndex(Role.KEY_ROLE_ON_CLIENT)));

                Role role = new Role();
                role.setId(id);
                role.setName(name);
                role.setIntroRequired(introRequired);
                role.setPhotoRequired(photoRequired);
                role.setOnClient(onClientRequired);

                list.add(role);
                cursor.moveToNext();
            }
        }
        cursor.close();
        db.close();
        return list;
    }

}
