/**
 * Created by Ebrar on 08/12/15.
 */

package com.beter.timehole.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.beter.timehole.R;
import com.beter.timehole.core.*;


import java.util.ArrayList;


public class ActivitiesFragment extends Fragment {

    public ActivitiesFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Tag defaultTag = new Tag("tag1");
        ArrayList<Tag> tags = null;
        tags.add(defaultTag);
        Activity activity1 = new Activity("ders",true,4,"19 08 1996","08 12 2015",tags,"Must do it carefully");
        Activity[] doneActivities ={activity1};
        ListAdapter DoneActivityList = new ArrayAdapter<Activity>(this,android.R.layout.simple_list_item_1,doneActivities);
        ListView ListView1 = (ListView) findViewById(R.id.ListView1);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.help_fragment, container, false);
    }


}
