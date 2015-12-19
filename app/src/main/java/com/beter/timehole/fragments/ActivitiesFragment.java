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


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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

        ArrayList<com.beter.timehole.core.Activity> activitiesList = readActivitiesFromFile();

        MyCustomAdapter adapter = new MyCustomAdapter(activitiesList,getActivity());
        ListView doneList = (ListView) ActivtiesRootView.findViewById(R.id.listView1);
        doneList.setAdapter(adapter);

        return ActivtiesRootView;
    }

    private ArrayList<com.beter.timehole.core.Activity> readActivitiesFromFile(){
        ArrayList<com.beter.timehole.core.Activity> activitiesFromFile = new ArrayList<>();
        try{
            FileInputStream activityFileInputStream = getContext().openFileInput("activityobjects.dat");
            ObjectInputStream activityObjectInputStream = new ObjectInputStream(activityFileInputStream);
            while(activityObjectInputStream.available() > 0){
                com.beter.timehole.core.Activity activity = (com.beter.timehole.core.Activity) activityObjectInputStream.readObject();
                activitiesFromFile.add(activity);
            }
            activityObjectInputStream.close();
            activityFileInputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return activitiesFromFile;
    }
}