package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class Person {

    private static final String TAG = Person.class.getSimpleName().toString();

    // Table Names
    public static final String TABLE = "Person";

    // Person Table - column names
    public static final String KEY_ID = "id";
    public static final String KEY_PERSON_NAME = "PersonName";
    public static final String KEY_PERSON_OTHER_NAMES = "PersonOtherNames";
    public static final String KEY_PERSON_DOB = "PersonDOB";
    public static final String KEY_PERSON_PHOTO = "PersonPhoto";
    public static final String KEY_PERSON_PHOTO_DESC = "PersonPhotoDesc";
    public static final String KEY_PERSON_ROLE_ID = "PersonMainRoleId";
    public static final String KEY_PERSON_INTRO_QUES_DESC = "PersonIntroQuestnirDesc";

    //  Need to appropriately configure types for DOB and Photo
    public String id;
    public String name;
    public String otherNames;
    public String dob;
    public String photo;
    public String photoDesc;
    public String roleId;
    public String questDesc;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOtherNames() {
        return otherNames;
    }

    public void setOtherNames(String otherNames) {
        this.otherNames = otherNames;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getPhotoDesc() {
        return photoDesc;
    }

    public void setPhotoDesc(String photoDesc) {
        this.photoDesc = photoDesc;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    public String getQuestDesc() {
        return questDesc;
    }

    public void setQuestDesc(String questdesc) {
        this.questDesc = questdesc;
    }



}
