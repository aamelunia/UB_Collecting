package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class Person extends Model {

    private static final String TAG = Person.class.getSimpleName().toString();

    //  Need to appropriately configure types for DOB and Photo
    public String name;
    public String otherNames;
    public String dob;
    public String photoPath;
    public String photoDesc;
    public String mainRoleId;
    public String introQuestDesc;


    public String getIdentifier() {
        return name;
    }

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

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }

    public String getPhotoDesc() {
        return photoDesc;
    }

    public void setPhotoDesc(String photoDesc) {
        this.photoDesc = photoDesc;
    }

    public String getMainRoleId() {
        return mainRoleId;
    }

    public void setMainRoleId(String roleId) {
        this.mainRoleId = roleId;
    }

    public String getIntroQuestDesc() {
        return introQuestDesc;
    }

    public void setIntroQuestDesc(String questdesc) {
        this.introQuestDesc = questdesc;
    }


}
