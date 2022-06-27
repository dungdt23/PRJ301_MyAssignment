/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Admin
 */
public class DateDBContext extends DBContext<Date> {

    public static void main(String[] args) {
        String sDate0 = "09-06-2022";
        Date date0 = null;
        try {
            date0 = new SimpleDateFormat("dd-MM-yyyy").parse(sDate0);
        } catch (ParseException e) {
            System.out.println(e.getMessage());
        }
//        System.out.println(date0.getDate());
//        System.out.println(date0.getDay());
        DateDBContext db = new DateDBContext();
        ArrayList<Date> dates = db.getWeek(date0);
        for (Date date : dates) {
            System.out.println(date.toString());
        }

//        Calendar c = Calendar.getInstance();
//        c.set(2020, 10, 10);
//        System.out.println(c.getTime().toString());
//        c.add(Calendar.DATE, 32);
//        System.out.println(c.getTime().toString());
    }

    public ArrayList<Date> getWeek(Date date0) {
        ArrayList<Date> dates = new ArrayList<>();
        Calendar c = Calendar.getInstance();
        int dayOfdate0 = date0.getDay();
        c.set(date0.getYear()+1900, date0.getMonth(), date0.getDate());
        //check if choosen day is sunday, set index = 7
        if (dayOfdate0 == 0) {
            dayOfdate0 = 7;
        }
        //add dates from monday to present into list
        for (int i = 1; i < dayOfdate0; i++) {
            int range;
            if (i == 1) {
                range = -(dayOfdate0 - i);
            } else {
                range = 1;
            }
            c.add(Calendar.DATE, range);
            dates.add(c.getTime());
        }
        //add present date into list
        dates.add(date0);
        //reset calendar to present date
        c.add(Calendar.DATE, 1);
        //add from next day to sunday into list
        for (int i = dayOfdate0 + 1; i < 8; i++) {
            int range = 1;
            c.add(Calendar.DATE, range);
            Date date = c.getTime();
            dates.add(date);
        }
        return dates;
    }

    @Override
    public ArrayList<Date> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Date get(Date entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void insert(Date entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Date entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Date entity) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
