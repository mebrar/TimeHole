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
        View ActivitiesRootView = inflater.inflate(R.layout.activity_fragment, container, false);
        ArrayList<com.beter.timehole.core.Activity> doneActivities = new ArrayList<com.beter.timehole.core.Activity>();
        doneActivities.add(doneSample);

        MyCustomAdapter adapter = new MyCustomAdapter(doneActivities,getActivity());
        ListView doneList = (ListView) ActivitiesRootView.findViewById(R.id.listView1);
        doneList.setAdapter(adapter);

        return ActivitiesRootView;
    }

}