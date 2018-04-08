package edu.buffalo.cse.ubcollecting.data.models;

import android.util.Log;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Formatter;

/**
 * Created by aamel786 on 2/17/18.
 */

public class Person extends Model {

    private static final String TAG = Person.class.getSimpleName().toString();

    //  Need to appropriately configure types for DOB and Photo
    public String name;
    public String otherNames;
    public String dob;
    public byte[] photo;
    public String photoDesc;
    public String mainRoleId;
    public String introQuestDesc;
    public String email;
    public String password;

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

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = genHash(password);
    }

    public static String genHash(String input){
        try {
            MessageDigest sha1 = MessageDigest.getInstance("SHA-1");
            byte[] sha1Hash = sha1.digest(input.getBytes()) ;
            Formatter formatter = new Formatter() ;
            for (byte b : sha1Hash) {
                formatter.format("%02x", b) ;
            }
            return formatter.toString() ;
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "SHA-1 algorithm not found", e);
            return null;
        }
    }
}
