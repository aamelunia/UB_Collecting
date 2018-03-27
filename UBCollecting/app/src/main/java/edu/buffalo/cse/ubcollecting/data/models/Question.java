package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class Question extends Model {

    private static final String TAG = Question.class.getSimpleName().toString();

    public String type;

    public String getId() {
        return id;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }



}
