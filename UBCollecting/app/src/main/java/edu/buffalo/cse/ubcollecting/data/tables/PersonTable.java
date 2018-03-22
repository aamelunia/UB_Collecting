package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.Person;
import edu.buffalo.cse.ubcollecting.data.models.Role;
import android.database.Cursor;


public class PersonTable {

    private Person person;

    public PersonTable () {

        person = new Person();

    }

    public static String createTable(){

        return "CREATE TABLE "
                + Person.TABLE + "( " + Person.KEY_ID + " TEXT PRIMARY KEY, " + Person.KEY_PERSON_NAME
                + " VARCHAR, " + Person.KEY_PERSON_OTHER_NAMES + " VARCHAR, " + Person.KEY_PERSON_DOB
                + " DATETIME, " + Person.KEY_PERSON_ROLE_ID + " TEXT," + Person.KEY_PERSON_PHOTO + " BLOB, "
                + Person.KEY_PERSON_PHOTO_DESC + " VARCHAR, " + Person.KEY_PERSON_INTRO_QUES_DESC + " VARCHAR,"
                + " FOREIGN KEY (" + Person.KEY_PERSON_ROLE_ID + ") REFERENCES " + Role.TABLE + " (" + Role.KEY_ID + ")"
                + ")";
    }

    public static int addPerson(Person person) {

        int personId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(Person.KEY_ID, person.getId());
        values.put(Person.KEY_PERSON_NAME, person.getName());
        values.put(Person.KEY_PERSON_OTHER_NAMES, person.getOtherNames());
        values.put(Person.KEY_PERSON_DOB, person.getDob());
        values.put(Person.KEY_PERSON_ROLE_ID, person.getRoleId());
        values.put(Person.KEY_PERSON_PHOTO, person.getPhoto());
        values.put(Person.KEY_PERSON_PHOTO_DESC, person.getPhotoDesc());
        values.put(Person.KEY_PERSON_INTRO_QUES_DESC, person.getQuestDesc());

        personId = (int) db.insert(Person.TABLE,null,values);

        DatabaseManager.getInstance().closeDatabase();

        return personId;

    }

//    public static Person findById(int id){
//
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//
//        String[] projection = {
//                Person.KEY_ID,
//                Person.KEY_PERSON_NAME,
//                Person.KEY_PERSON_DOB,
//                Person.KEY_PERSON_OTHER_NAMES,
//                Person.KEY_PERSON_ROLE_ID,
//        };
//
//        String selection = Person.KEY_ID + " = ?";
//        String [] selectionArgs = { String.valueOf(id) };
//
//        Cursor cursor = db.query(
//                Person.TABLE,
//                projection,
//                selection,
//                selectionArgs,
//                null,
//                null,
//                null
//        );
//
//
//        if (cursor != null){
//            cursor.moveToFirst();
//        }
//
//        Person person = new Person();
//        person.setId(Integer.parseInt(cursor.getString(0)));
//        person.setName(cursor.getString(1));
//        person.setDob(cursor.getString(2));
//        person.setOtherNames(cursor.getString(3));
//        person.setRoleId(Integer.parseInt(cursor.getString(4)));
//
//        cursor.close();
//
//        DatabaseManager.getInstance().closeDatabase();
//
//        return person;
//
//    }

}
