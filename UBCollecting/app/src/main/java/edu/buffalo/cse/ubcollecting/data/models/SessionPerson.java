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
    public static final String KEY_SESSION_PERSON_ID = "SessionPersonId";
    public static final String KEY_SESSION_PERSON_ROLE_ID = "SessionPersonRoleId";


    public String sessionId;
    public String personId;
    public String roleId;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }




}
