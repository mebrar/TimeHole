/**
 * Created by Ebrar on 08/12/15.
 */
package com.beter.timehole.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import com.beter.timehole.*;
import com.beter.timehole.R;
import com.beter.timehole.core.Reminder;
import com.beter.timehole.core.Tag;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import android.util.Log;

public class ReminderFragment extends Fragment {

    private static final String TAG = "checkControl";
    private ArrayList<Reminder> reminderArrayList = new ArrayList<>();
    public static Reminder firstReminder = null;

    public ReminderFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View reminderRootView = inflater.inflate(R.layout.reminder_fragment, container, false);

        reminderArrayList = readRemindersFromFile();
        if(!reminderArrayList.isEmpty()){
            firstReminder = reminderArrayList.get(0);
        }
        CustomReminderAdapter adapter = new CustomReminderAdapter(reminderArrayList,getActivity());
        ListView reminderlist = (ListView) reminderRootView.findViewById(R.id.listView);
        reminderlist.setAdapter(adapter);

        return reminderRootView;
    }


    private ArrayList<Reminder> readRemindersFromFile(){
        ArrayList<Reminder> remindersFromFile = new ArrayList<>();
        try{
            FileInputStream reminderFileInputStream = getContext().openFileInput("reminderobjects.dat");
            ObjectInputStream reminderObjectInputStream = new ObjectInputStream(reminderFileInputStream);
            remindersFromFile = (ArrayList<Reminder>)reminderObjectInputStream.readObject();
            reminderObjectInputStream.close();
            reminderFileInputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return remindersFromFile;
    }

}
