package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */

import android.util.Log;

import edu.buffalo.cse.ubcollecting.data.models.Person;


public class PersonTable extends Table<Person> {

    public static final String TABLE = "Person";

    // Person Table - column names
    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "Name";
    public static final String KEY_OTHER_NAMES = "OtherNames";
    public static final String KEY_DOB = "DOB";
    public static final String KEY_PHOTO = "Photo";
    public static final String KEY_PHOTO_DESC = "PhotoDesc";
    public static final String KEY_MAIN_ROLE_ID = "MainRoleId";
    public static final String KEY_INTRO_QUEST_DESC = "IntroQuestDesc";

    public PersonTable () {
        super();
    }

    @Override
    public String createTable(){
        Log.i("PERSON TABLE:",TABLE);
        return "CREATE TABLE "
                + TABLE + "( " + KEY_ID + " TEXT PRIMARY KEY, " + KEY_NAME
                + " VARCHAR, " + KEY_OTHER_NAMES + " VARCHAR, " + KEY_DOB
                + " DATETIME, " + KEY_MAIN_ROLE_ID + " TEXT," + KEY_PHOTO + " BLOB, "
                + KEY_PHOTO_DESC + " VARCHAR, " + KEY_INTRO_QUEST_DESC + " VARCHAR,"
                + " FOREIGN KEY (" + KEY_MAIN_ROLE_ID + ") REFERENCES " + RoleTable.TABLE
                + " (" + RoleTable.KEY_ID + ")" + ")";
    }

    @Override
    public String getTableName(){
        return TABLE;
    }

//    public static int addPerson(Person person) {
//
//        int personId;
//
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//        ContentValues values = new ContentValues();
//        values.put(Person.KEY_ID, person.getId());
//        values.put(Person.KEY_NAME, person.getName());
//        values.put(Person.KEY_OTHER_NAMES, person.getOtherNames());
//        values.put(Person.KEY_DOB, person.getDob());
//        values.put(Person.KEY_MAIN_ROLE_ID, person.getRoleId());
//        values.put(Person.KEY_PHOTO, person.getPhoto());
//        values.put(Person.KEY_PHOTO_DESC, person.getPhotoDesc());
//        values.put(Person.KEY_INTRO_QUEST_DESC, person.getIntroQuestDesc());
//
//        personId = (int) db.insert(Person.TABLE,null,values);
//
//        DatabaseManager.getInstance().closeDatabase();
//
//        return personId;
//
//    }

//    public static Person findById(int id){
//
//        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
//
//        String[] projection = {
//                Person.KEY_ID,
//                Person.KEY_NAME,
//                Person.KEY_DOB,
//                Person.KEY_OTHER_NAMES,
//                Person.KEY_MAIN_ROLE_ID,
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
