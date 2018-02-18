package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.File;

public class FileTable {

    private File file;

    public FileTable () {

        file = new File();

    }

    public static String createTable(){
        //  Added primary key below unlike in original script
        return "CREATE TABLE "
                + File.TABLE + "(" + File.KEY_FILE_ID + " TEXT PRIMARY KEY," + File.KEY_FILE_NAME
                + " VARCHAR," + File.KEY_FILE_ANSWER_ID + " TEXT," + File.KEY_FILE_TYPE
                + " VARCHAR," + File.KEY_FILE_PATH + " VARCHAR," + File.KEY_FILE_CREATOR
                + " TEXT," + File.KEY_FILE_START + " DATETIME," + File.KEY_FILE_END
                + " DATETIME" + ")";
    }

    public int addFile(File file) {

        int fileId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(File.KEY_FILE_ID, file.getId());
        values.put(File.KEY_FILE_NAME, file.getName());
        values.put(File.KEY_FILE_ANSWER_ID, file.getAnswerId());
        values.put(File.KEY_FILE_TYPE, file.getType());
        values.put(File.KEY_FILE_PATH, file.getPath());
        values.put(File.KEY_FILE_CREATOR, file.getCreator());
        values.put(File.KEY_FILE_START, file.getStartTime());
        values.put(File.KEY_FILE_END, file.getEndTime());

        fileId = (int) db.insert(File.TABLE,null,values);

        DatabaseManager.getInstance().closeDatabase();

        return fileId;

    }

}
