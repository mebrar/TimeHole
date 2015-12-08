/**
 * Created by Ebrar on 01/12/15.
 */
package com.beter.timehole.core;

public class Tag {
    private String tagName;
    public Tag(String tagName){
        this.tagName=tagName;
    }

    @Override
    public String toString() {
        return  tagName ;
    }
}
