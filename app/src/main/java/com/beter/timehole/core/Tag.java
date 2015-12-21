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
    public static final int redColor = Color.parseColor("#F44336");
    public static final int brownColor = Color.parseColor("#795548");
    public static final int darkBlue = Color.parseColor("#0D47A1");
    public static final int blueGrey = Color.parseColor("#607D8B");
    public static final int greenColor = Color.parseColor("#4CAF50");
    public static final int purpleColor = Color.parseColor("#9C27B0");
    public static final int pinkColor = Color.parseColor("#E91E63");
    public static final int orangeColor = Color.parseColor("#FF9800");
    public static final int tealColor = Color.parseColor("#009688");
    public static final int yellowColor = Color.parseColor("#FFEB3B");
    public static final int lightBlue = Color.parseColor("#03A9F4");
    public static final int deepPurple = Color.parseColor("#673AB7");

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
