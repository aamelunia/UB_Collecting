package edu.buffalo.cse.ubcollecting.data.tables;

/**
 * Created by aamel786 on 3/24/18.
 */

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.Model;

public abstract class Table <E extends Model> {

    public static String TABLE;
    public static Field [] tableColumns;

    public Table () {

    }

    public abstract String createTable();


    public long addEntry (Model model) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {

        long rowId;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();

        ArrayList<Method> getters = model.getGetters();

        for (int i=0; i<tableColumns.length; i++){

            String key = tableColumns[i].getName();
            Object value = getters.get(i).invoke(model,null);
            insertContent(values,key,value);

        }

        rowId = db.insert(TABLE,null,values);

        DatabaseManager.getInstance().closeDatabase();

        return rowId;

    }

    private void insertContent(ContentValues values, String key, Object value){

        if (value instanceof Integer){
            values.put(key,(Integer) value);
        }
        else if (value instanceof String){
            values.put(key,(String) value);
        }

    }


}
