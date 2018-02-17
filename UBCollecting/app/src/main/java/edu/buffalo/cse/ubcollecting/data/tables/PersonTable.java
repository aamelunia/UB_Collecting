package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */

import edu.buffalo.cse.ubcollecting.data.models.Person;

public class PersonTable {

    private Person person;

    public PersonTable () {

        person = new Person();

    }

    public static String createTable(){

        return "CREATE TABLE "
                + Person.TABLE + "(" + Person.KEY_PERSON_ID + " TEXT," + Person.KEY_PERSON_NAME
                + " VARCHAR," + Person.KEY_PERSON_OTHER_NAMES + " VARCHAR," + Person.KEY_PERSON_DOB
                + " DATETIME," + Person.KEY_PERSON_ROLE + " TEXT," + Person.KEY_PERSON_PHOTO
                + " BLOB," + Person.KEY_PERSON_PHOTO_DESC + " VARCHAR," + Person.KEY_PERSON_INTO_QUES_DESC
                + " VARCHAR" + ")";
    }

}
