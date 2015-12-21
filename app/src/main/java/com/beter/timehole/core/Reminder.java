package com.beter.timehole.core;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Ebrar on 01/12/15.
 */
public class Reminder implements java.io.Serializable {

    private String name;
    private Date date;
    private String note;
    private String notification;
    private ArrayList<Tag> tags;
    Priority priority;
    public static final long serialVersionUID = 1234L;

    public Reminder(Date date, String name, String note, String notification, ArrayList<Tag> tag) {
        this.date = date;
        this.name = name;
        this.note = note;
        this.notification = notification;
        this.tags = tag;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNotification() {
        return notification;
    }

    public void setNotification(String notification) {
        this.notification = notification;
    }

    public ArrayList<Tag> getTag() {
        return tags;
    }

    public void setTag(ArrayList<Tag> tag) {
        this.tags = tag;
    }

    public void addTag(Tag tag){
        tags.add(tag);
    }

    public void setPriority(Priority priority){
        this.priority = priority;
    }

    public Priority getPriority(){
        return priority;
    }

    @Override
    public String toString() {
        if(note.equals(""))
            note="-";
        if(name.equals(""))
            name="-";

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        int year = calendar.get(Calendar.YEAR)-1900;

        int month = (calendar.get(Calendar.MONTH) + 1);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        String result = "Name: " +name + "\n" + "Note  : " + note + "\n"+"Date  : "+day+"/"+(month) + "/" + year + "\n"+ "Time : " + date.getHours() +":" + date.getMinutes();

        return result;
    }

}
