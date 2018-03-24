package edu.buffalo.cse.ubcollecting.data.models;

import java.lang.reflect.Method;
import java.util.ArrayList;

/**
 * Created by aamel786 on 3/24/18.
 */

public abstract class Model {

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

}
