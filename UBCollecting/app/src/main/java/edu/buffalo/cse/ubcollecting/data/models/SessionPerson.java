package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class SessionPerson {

    private static final String TAG = SessionPerson.class.getSimpleName().toString();

    // Table Names
    public static final String TABLE = "SessionPerson";

    // SessionPerson Table - column names
    public static final String KEY_SESSION_ID = "SessionId";
    public static final String KEY_PERSON_ID = "PersonId";
    public static final String KEY_ROLE_ID = "RoleId";


    public int sessionId;
    public int personId;
    public int roleId;

    public int getSessionId() {
        return sessionId;
    }

    public void setSessionId(int sessionId) {
        this.sessionId = sessionId;
    }

    public int getPersonId() {
        return personId;
    }

    public void setPersonId(int personId) {
        this.personId = personId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }



}
