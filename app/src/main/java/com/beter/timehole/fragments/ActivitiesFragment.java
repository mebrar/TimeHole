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


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        ArrayList<Tag> tags1= new ArrayList<Tag>();
        tags1.add(new Tag("Calisma"));

        ArrayList<Tag> tags2= new ArrayList<Tag>();
        tags2.add(new Tag("Eglence"));

        com.beter.timehole.core.Activity doneSample = new com.beter.timehole.core.Activity("ders",true,70,"16 50","17 00",tags1,"ben yaptim");
        com.beter.timehole.core.Activity undoneSample = new com.beter.timehole.core.Activity("ders",false,30,"13 30","14 00",tags2,"ben yapacagim");
        View rootView = inflater.inflate(R.layout.activity_fragment, container, false);
        ArrayList<com.beter.timehole.core.Activity> doneActivities = new ArrayList<com.beter.timehole.core.Activity>();
        doneActivities.add(doneSample);
        ListView doneList = (ListView) rootView.findViewById(R.id.listView1);
        doneList.setAdapter(new ArrayAdapter<com.beter.timehole.core.Activity>(getActivity(), R.layout.support_simple_spinner_dropdown_item, doneActivities));

        ArrayList<com.beter.timehole.core.Activity> undoneActivities = new ArrayList<com.beter.timehole.core.Activity>();
        undoneActivities.add(undoneSample);
        ListView undoneList = (ListView) rootView.findViewById(R.id.listView1);
        undoneList.setAdapter(new ArrayAdapter<com.beter.timehole.core.Activity>(getActivity(),R.layout.support_simple_spinner_dropdown_item,undoneActivities));

        return rootView;
    }


}
