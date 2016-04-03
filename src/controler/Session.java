/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controler;

import bean.CorpDetat;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ayoub
 */
public class Session {

    public static List<SessionItem> myMap = new ArrayList<>();

    public static Object getAttribut(String name) {

        for (int i = 0; i < myMap.size(); i++) {
            SessionItem sessionItem = myMap.get(i);
            if (sessionItem.getKey().equals(name)) {
                return sessionItem.getObject();
            }
        }
        return null;
    }

    public static int setAttribut(Object obj, String name) {
        SessionItem sessionItem = new SessionItem();
        sessionItem.setKey(name);
        sessionItem.setObject(obj);
        myMap.add(sessionItem);
        return 1;
    }

    public static int setAttributList(List<Object> objss, String name) {
        for (Object object : objss) {
            setAttribut(object, name);
        }
        return 1;

    }

    public static List<Object> getAttributList(String name) {
        List<Object> objess = new ArrayList<>();

        for (int i = 0; i < myMap.size(); i++) {
            SessionItem sessionItem = myMap.get(i);
            if (sessionItem.getKey().equals(name)) {
                objess.add(sessionItem.getObject());
            }

        }
        return objess;
    }

   
}
