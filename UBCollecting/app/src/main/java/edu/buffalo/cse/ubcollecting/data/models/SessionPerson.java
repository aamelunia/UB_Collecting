package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class SessionPerson extends Model {

    private static final String TAG = SessionPerson.class.getSimpleName().toString();

    public String sessionId;
    public String personId;
    public String roleId;

    public String getIdentifier() {
        //TODO
        return "SESSION PERSON";
    }

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
