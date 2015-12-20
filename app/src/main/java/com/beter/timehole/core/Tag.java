/**
 * Created by Ebrar on 01/12/15.
 */
package com.beter.timehole.core;
import android.graphics.Color;

import java.util.ArrayList;

public class Tag implements java.io.Serializable {

    private String tagName;
    private int mycolor;
    public static final long serialVersionUID = 12341234L;

    public Tag(String tagName) {
        this.tagName = tagName;
        this.mycolor = Color.CYAN;
    }
    public Tag(String tagName,int mycolor) {
        this.tagName = tagName;
        this.mycolor = mycolor;
    }

    public String getTagName() {
        return tagName;
    }

    public int getColor() {
        return mycolor;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public void setMycolor(int mycolor) {
        this.mycolor = mycolor;
    }

    public ArrayList addTag(String tagName, int color, ArrayList<Tag> list){
        list.add(new Tag(tagName,color));
        return list;
    }
    public Tag editTag(Tag mytag, String newName, int newColor){
        mytag.setTagName(newName);
        mytag.setMycolor(newColor);
        return mytag;
    }
    public ArrayList<Tag> removeTag(Tag tag, ArrayList<Tag> list){
        return list;
    }

    @Override
    public String toString() {
        return  tagName ;
    }
}
