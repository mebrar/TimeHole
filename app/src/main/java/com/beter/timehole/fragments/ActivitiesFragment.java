/**
 * Created by Ebrar on 08/12/15.
 */

package com.beter.timehole.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.beter.timehole.R;
import com.beter.timehole.core.*;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


public class ActivitiesFragment extends Fragment {

    private ArrayList<Activity> activitiesArrayList = new ArrayList<>();

    public ActivitiesFragment() {
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View ActivitiesRootView = inflater.inflate(R.layout.activity_fragment, container, false);

        activitiesArrayList = readActivitiesFromFile();

        MyCustomAdapter adapter = new MyCustomAdapter(activitiesArrayList,getActivity());
        ListView doneList = (ListView) ActivitiesRootView.findViewById(R.id.listView1);
        doneList.setAdapter(adapter);

        return ActivitiesRootView;
    }

    private ArrayList<Activity> readActivitiesFromFile(){
        ArrayList<Activity> activitiesFromFile = new ArrayList<>();
        try{
            FileInputStream activityFileInputStream = getContext().openFileInput("activityobjects.dat");
            ObjectInputStream activityObjectInputStream = new ObjectInputStream(activityFileInputStream);
            activitiesFromFile = (ArrayList<Activity>)activityObjectInputStream.readObject();
            activityObjectInputStream.close();
            activityFileInputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return activitiesFromFile;
    }

}