package edu.buffalo.cse.ubcollecting.data.models;

import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by aamel786 on 3/24/18.
 */

public abstract class Model implements Serializable {

    public String id;

    public Model() {
        id = generateID();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public abstract String getIdentifier();

    public ArrayList<Method> getGetters() {

        Method[] m = this.getClass().getDeclaredMethods();
        ArrayList<Method> getters = new ArrayList<>();

        for (int i = 0; i < m.length; i++) {
            if (m[i].getName().startsWith("get") && !m[i].getName().equals("getIdentifier")) {
                getters.add(m[i]);
            }
        }

        m = this.getClass().getMethods();

        for (int i = 0; i < m.length; i++) {
            if (m[i].getName().equals("getId")) {
                getters.add(m[i]);
                break;
            }
        }

        return getters;
    }

    public ArrayList<Method> getSetters() {

        Method[] m = this.getClass().getDeclaredMethods();
        ArrayList<Method> setters = new ArrayList<>();

        for (int i = 0; i < m.length; i++) {
            if (m[i].getName().startsWith("set")) {
                setters.add(m[i]);
            }
        }

        m = this.getClass().getMethods();

        for (int i = 0; i < m.length; i++) {
            if (m[i].getName().equals("setId")) {
                setters.add(m[i]);
                break;
            }
        }

        return setters;
    }

    public String generateID() {
        String s = "";
        while (s.length() < 5) {
            s = "0" + s;
        }
        return "1" + s + String.valueOf(System.currentTimeMillis());
    }


    //TODO
    @Override
    public String toString() {
        return getIdentifier();
    }

}
