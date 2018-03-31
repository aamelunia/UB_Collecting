package edu.buffalo.cse.ubcollecting.data.tables;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import edu.buffalo.cse.ubcollecting.data.DatabaseManager;
import edu.buffalo.cse.ubcollecting.data.models.Model;

/**
 * Created by aamel786 on 3/31/18.
 */

public abstract class MainTable<E extends Model> extends Table<E> {

    //    STILL HAVE TO TO DO TABLE COLUMNS AND GETTERS/SETTERS SORTING TO BE SAFE

    public MainTable() {

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

//            Collections.sort(setters, new MethodComparator());

            if (cursor.moveToFirst()) {

                for (int i = 0; i < tableColumns.size(); i++) {
                    String key = tableColumns.get(i);
                    Method method = setters.get(i);
                    insertIntoObject(cursor, model, key, method);
                }

            }

            cursor.close();

            DatabaseManager.getInstance().closeDatabase();

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return model;

    }


    public void update(Model model) {

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();
        ContentValues updatedValues = new ContentValues();

        ArrayList<Method> getters = model.getGetters();

//        Collections.sort(getters, new MethodComparator());

        String id = null;

        for (int i = 0; i < tableColumns.size(); i++) {

            try {
                String key = tableColumns.get(i);
                Object value = getters.get(i).invoke(model, null);
                insertContent(updatedValues, key, value);
                if (getters.get(i).getName().equals("getId")) {
                    id = (String) value;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

        }

        String selection = "id = ?";

        String[] selectionArgs = {id};

        db.update(this.getTableName(), updatedValues, selection, selectionArgs);

        DatabaseManager.getInstance().closeDatabase();

    }

    public void delete(String id) {

        SQLiteDatabase db = DatabaseManager.getInstance().openDatabase();

        String selection = "id = ?";

        String[] selectionArgs = {id};

        db.delete(this.getTableName(), selection, selectionArgs);

        DatabaseManager.getInstance().closeDatabase();

    }


}
