/**
 * Created by Ebrar on 01/12/15.
 */
package com.beter.timehole.core;

import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;

public class Activity {
    private String name;
    private boolean done;
    private long duration;
    private String startDate;
    private String finishDate;
    private ArrayList<Tag> tags = null;
    private String note;

    public Activity(String name, boolean done, long duration, String startDate, String finishDate, ArrayList<Tag> tags, String note){
        this.name = name;
        this.done = done;
        this.duration = duration;
        this.startDate = startDate;
        this.finishDate = finishDate;
        this.tags = tags;
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

    public ArrayList<Tag> getTags() {
        return tags;
    }

    public String getNote() {
        return note;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getFinishDate() {
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

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }
    /** setTags methodu kullan�c� tagleri de�i�tirmek istedi�inde en ba�tan se�erse yararl�
    ancak sadece ekstra bir tag eklemek istedi�i durumlar i�in tag ekleme methodu gerekli**/
    public void addTag(Tag tag)
    {
        tags.add(tag);
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        String result;
        result= name + " " + finishDate + "\n" ;
        for(int i=0;i<tags.size();i++)
        {
            result+= tags.get(i)+" ";
        }
        return result;
    }
}
