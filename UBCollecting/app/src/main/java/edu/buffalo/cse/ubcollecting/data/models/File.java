package edu.buffalo.cse.ubcollecting.data.models;

/**
 * Created by aamel786 on 2/17/18.
 */

public class File {

    private static final String TAG = File.class.getSimpleName().toString();

    // Table Names
    public static final String TABLE = "File";

    // Session Table - column names
    public static final String KEY_FILE_ID = "FileId";
    public static final String KEY_FILE_NAME = "FileName";
    public static final String KEY_FILE_ANSWER_ID = "FileAnswerId";
    public static final String KEY_FILE_TYPE = "FileType";
    public static final String KEY_FILE_PATH = "FilePath";
    public static final String KEY_FILE_CREATOR = "FileCreator";
    public static final String KEY_FILE_START = "FileStartTime";
    public static final String KEY_FILE_END = "FileEndTime";

    //  Need to appropriately configure type for start time and end time

    public String id;
    public String name;
    public String answerId;
    public String type;
    public String path;
    public String creator;
    public String startTime;
    public String endTime;


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

    public String getAnswerId() {
        return answerId;
    }

    public void setAnswerId(String answerId) {
        this.answerId = answerId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }



}
