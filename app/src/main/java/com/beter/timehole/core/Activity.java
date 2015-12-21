/**
 * Created by Ebrar on 01/12/15.
 */
package com.beter.timehole.core;

import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.Date;

public class Activity implements java.io.Serializable {

    private String name;
    private boolean done;
    private long duration;
    private Date startDate;
    private Date finishDate;
    private Tag tag = null;
    private String note;
    public static final long serialVersionUID = 4321L;

    public Activity(String name, boolean done, long duration, Date startDate, Date finishDate, Tag tag, String note){
        this.name = name;
        this.done = done;
        this.duration = duration;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.tag = tag;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public boolean isDone() {
        return done;
    }

    public long getDuration() {
        return duration;
    }

    public Tag getTags() {
        return tag;
    }

    public String getNote() {
        return note;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public void setTags(Tag tag) {
        this.tag = tag;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        String result;
        result= name + " " + duration + " "+tag ;
        return result;
    }


}
