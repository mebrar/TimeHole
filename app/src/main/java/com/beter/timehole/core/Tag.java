/**
 * Created by Ebrar on 01/12/15.
 */
package com.beter.timehole.core;

public class Tag implements java.io.Serializable {

    private String tagName;
    public static final long serialVersionUID = 12341234L;

    public Tag(String tagName){
        this.tagName=tagName;
    }

    public String getTagName() {
        return tagName;
    }

    @Override
    public String toString() {
        return  tagName ;
    }
}
