package edu.buffalo.cse.ubcollecting.data.models;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by aamel786 on 3/24/18.
 */

public abstract class Model {

    public String id;

    public Model() {
        id = generateID();
    }

    public ArrayList<Method> getGetters () {

        Method [] m = this.getClass().getDeclaredMethods();
        ArrayList <Method> getters = new ArrayList<>();

        for (int i = 0; i < m.length; i++){
            if(m[i].getName().startsWith("get")) {
                getters.add(m[i]);
            }
        }

        return getters;
    }

    public ArrayList<Method> getSetters () {

        Method [] m = this.getClass().getDeclaredMethods();
        ArrayList <Method> setters = new ArrayList<>();

        for (int i = 0; i < m.length; i++){
            if(m[i].getName().startsWith("set")) {
                setters.add(m[i]);
            }
        }

        return setters;
    }

    public String generateID() {
        String s = "";
        while (s.length() < 5) {
            s = "0" + s;
        }
        return "1"+ s + String.valueOf(System.currentTimeMillis());
    }
}
