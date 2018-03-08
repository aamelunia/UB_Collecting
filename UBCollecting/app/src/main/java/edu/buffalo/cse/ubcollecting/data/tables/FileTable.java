package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 2/17/18.
 */
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.Answer;
import edu.buffalo.cse.ubcollecting.data.models.File;
import edu.buffalo.cse.ubcollecting.data.models.Person;
import edu.buffalo.cse.ubcollecting.data.models.Questionnaire;
import edu.buffalo.cse.ubcollecting.data.models.QuestionnaireType;

public class FileTable {

    private File file;

    public FileTable () {

        file = new File();

    }

    public static String createTable(){
        return "CREATE TABLE "
                + File.TABLE + "(" + File.KEY_ID + " INTEGER PRIMARY KEY," + File.KEY_FILE_NAME
                + " VARCHAR," + File.KEY_FILE_ANSWER_ID + " INTEGER," + File.KEY_FILE_TYPE
                + " VARCHAR," + File.KEY_FILE_PATH + " VARCHAR," + File.KEY_FILE_CREATOR_ID
                + " INTEGER,"  + File.KEY_FILE_START + " DATETIME," + File.KEY_FILE_END + " DATETIME,"
                + " FOREIGN KEY(" + File.KEY_FILE_ANSWER_ID + ") REFERENCES " + Answer.TABLE
                + " (" + Answer.KEY_ID + ")," + " FOREIGN KEY(" + File.KEY_FILE_CREATOR_ID + ") REFERENCES "
                + Person.TABLE + " (" + Person.KEY_ID + ")" + ")";
    }

    public static int addFile(File file) {

        int fileId;

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();
        values.put(File.KEY_FILE_NAME, file.getName());
        values.put(File.KEY_FILE_ANSWER_ID, file.getAnswerId());
        values.put(File.KEY_FILE_TYPE, file.getType());
        values.put(File.KEY_FILE_PATH, file.getPath());
        values.put(File.KEY_FILE_CREATOR_ID, file.getCreatorId());
        values.put(File.KEY_FILE_START, file.getStartTime());
        values.put(File.KEY_FILE_END, file.getEndTime());

        fileId = (int) db.insert(File.TABLE,null,values);

        DatabaseManager.getInstance().closeDatabase();

        return fileId;

    }

}
