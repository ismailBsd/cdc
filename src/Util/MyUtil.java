/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Ayoub
 */
public class MyUtil {

    public static String myDate(Date date) {
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(date!=null)
        return dateFormat.format(date);
        
        return null;
    }

    public static String DateSys() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = dateFormat.format(date);
        return dateString;
    }

    public static String DateSysSansH() {
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = dateFormat.format(date);
        return dateString;
    }
}