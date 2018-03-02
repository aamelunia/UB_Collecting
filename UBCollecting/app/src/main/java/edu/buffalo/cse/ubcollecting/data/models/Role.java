package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class Role  {

    private static final String TAG = Role.class.getSimpleName().toString();

    // Table Names
    public static final String TABLE = "Role";

    // Role Table - column names
    public static final String KEY_ID = "_id";
    public static final String KEY_ROLE_NAME = "RoleName";
    public static final String KEY_ROLE_INTRO_REQUIRED = "RoleIntroRequired";
    public static final String KEY_ROLE_PHOTO_REQUIRED = "RolePhotoRequired";
    public static final String KEY_ROLE_ON_CLIENT = "RoleOnClient";

    public int id;
    public String name;
    public int introRequired;
    public int photoRequired;
    public int onClient;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIntroRequired() {
        return introRequired;
    }

    public void setIntroRequired(int introRequired) {
        this.introRequired = introRequired;
    }

    public int getPhotoRequired() {
        return photoRequired;
    }

    public void setPhotoRequired(int photoRequired) {
        this.photoRequired = photoRequired;
    }

    public int getOnClient() {
        return onClient;
    }

    public void setOnClient(int onClient) {
        this.onClient = onClient;
    }



}
