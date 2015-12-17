package com.beter.timehole.core;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Ebrar on 01/12/15.
 */
public class Reminder {
    private String name;
    private Date date;
    private String note;
    private String notification;
    private ArrayList<Tag> tags;

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


    @Override
    public String toString() {
        String result = name + date;
        for(int i = 0; i<tags.size();i++)
            result += tags.get(i);
        return result;
    }
}
