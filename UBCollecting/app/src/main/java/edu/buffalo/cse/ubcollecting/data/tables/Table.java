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

    public ArrayList <String> tableColumns;

    public Table() {
        tableColumns = this.getAllColumnNames();
    }

    public abstract String createTable();

    public abstract String getTableName ();


    public long addEntry (Model model) {

        long rowId;
        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues values = new ContentValues();

        ArrayList<Method> getters = model.getGetters();

        for (int i=0; i<tableColumns.size(); i++){

            try {
            String key = tableColumns.get(i);
            Object value = getters.get(i).invoke(model,null);
            insertContent(values,key,value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }

        rowId = db.insert(this.getTableName(),null,values);

        DatabaseManager.getInstance().closeDatabase();

        return rowId;
    }

    private void insertContent(ContentValues values, String key, Object value) {

        if (value instanceof Integer){
            values.put(key,(Integer) value);
        }
        else if (value instanceof String){
            values.put(key,(String) value);
        }

    }

    private ArrayList<String> getAllColumnNames () {

        Field [] allFields = this.getClass().getDeclaredFields();
        ArrayList <String> allColumnNames = new ArrayList<>();

        for (int i = 0; i < allFields.length; i++){

            if(allFields[i].getName().startsWith("KEY")) {
                try {
                    Field field = allFields[i];
                    allColumnNames.add((String) field.get(this));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }

        }

        return allColumnNames;
    }


}
