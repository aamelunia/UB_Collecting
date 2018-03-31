package edu.buffalo.cse.ubcollecting.data.tables;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.Method;
import java.util.ArrayList;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.Model;

/**
 * Created by aamel786 on 3/31/18.
 */

public abstract class MainTable <E extends Model> extends Table <E> {

    public MainTable(){

    }


    public E findById(String id) {

        E model = null;

        try {

            Class theClass = Class.forName(MODEL_PATH + this.getTableName());

            model = (E) theClass.newInstance();

            String selectQuery = "SELECT  * FROM " + this.getTableName() + " WHERE id = " + id;

            SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

            Cursor cursor = db.rawQuery(selectQuery, null);

            ArrayList<Method> setters = model.getSetters();

            if (cursor.moveToFirst()) {

                for (int i=0; i<tableColumns.size(); i++){
                    String key = tableColumns.get(i);
                    Method method = setters.get(i);
                    insertIntoObject(cursor,model,key,method);
                }

            }

            cursor.close();

            DatabaseManager.getInstance().closeDatabase();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return model;

    }


}
