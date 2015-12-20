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
    private ArrayList<Tag> tags = null;
    private String note;
    public static final long serialVersionUID = 4321L;

    public Activity(String name, boolean done, long duration, Date startDate, Date finishDate, ArrayList<Tag> tags, String note){
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

    /**
     * setTags methodu kullanıcı taglerı degıstırmek ıstedıgınde en bastan secerse yararlı
     * ancak sadece ekstra bır tag eklemek ıstedıgı durumlar ıcın tag ekleme methodu gereklı
     **/

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

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
        result= name + " " + duration + "\n" ;
        for(int i=0;i<tags.size();i++)
        {
            result+= tags.get(i)+" ";
        }
        return result;
    }


}
