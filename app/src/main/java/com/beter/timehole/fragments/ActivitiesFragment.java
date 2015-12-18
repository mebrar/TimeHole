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

        View ActivtiesRootView = inflater.inflate(R.layout.activity_fragment, container, false);

        ArrayList<Tag> tags1= new ArrayList<Tag>();
        tags1.add(new Tag("Calisma"));

        com.beter.timehole.core.Activity doneSample = new com.beter.timehole.core.Activity("ders",true,70,"16 50","17 00",tags1,"ben yaptim");
        com.beter.timehole.core.Activity doneSample1 = new com.beter.timehole.core.Activity("ders1",false,70,"16 50","17 00",tags1,"ben yapcam1");
        com.beter.timehole.core.Activity doneSample2 = new com.beter.timehole.core.Activity("ders2",true,70,"16 50","17 00",tags1,"ben yaptim2");
        com.beter.timehole.core.Activity doneSample3 = new com.beter.timehole.core.Activity("ders3",false,70,"16 50","17 00",tags1,"ben yapcam3");

        ArrayList<com.beter.timehole.core.Activity> doneActivities = new ArrayList<com.beter.timehole.core.Activity>();
        doneActivities.add(doneSample);
        doneActivities.add(doneSample1);
        doneActivities.add(doneSample2);
        doneActivities.add(doneSample3);


        MyCustomAdapter adapter = new MyCustomAdapter(doneActivities,getActivity());
        ListView doneList = (ListView) ActivtiesRootView.findViewById(R.id.listView1);
        doneList.setAdapter(adapter);

        return ActivtiesRootView;
    }

}