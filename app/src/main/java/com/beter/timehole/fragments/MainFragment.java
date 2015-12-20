/**
 * Created by Ebrar on 08/12/15.
 */
package com.beter.timehole.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.widget.CardView;
import android.support.design.widget.NavigationView;
import android.widget.TextView;


import com.beter.timehole.*;
import com.beter.timehole.core.Activity;
import com.beter.timehole.core.Reminder;
import com.beter.timehole.R;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class MainFragment extends Fragment {

    static FragmentTransaction fragmentTransaction;
    CardView activitiesCardView;
    CardView reminderCardView;
    NavigationView navView;

    public MainFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mainRootView = inflater.inflate(R.layout.main_fragment, container, false);

        activitiesCardView = (CardView)mainRootView.findViewById(R.id.activity_card);
        reminderCardView = (CardView)mainRootView.findViewById(R.id.reminder_card);
        navView = (NavigationView)(getActivity().findViewById(R.id.nav_view));
        ArrayList<Reminder> reminderListFromFile = readRemindersFromFile();
        ArrayList<Activity> activitiesListFromFile = readActivitiesFromFile();
        TextView lastReminderTextView = (TextView)getActivity().findViewById(R.id.last_reminders);
        TextView lastActivityTextView = (TextView)getActivity().findViewById(R.id.last_activities);
        Reminder lastReminder;
        Activity lastActivity;

        if(reminderListFromFile.isEmpty()){
            lastReminderTextView.setText("No reminder created yet...");
        }
        else{
            lastReminder = reminderListFromFile.get(reminderListFromFile.size()-1);
            lastReminderTextView.setText(lastReminder.toString());
        }

        if(activitiesListFromFile.isEmpty()){
            lastActivityTextView.setText("No activity created yet...");
        }
        else{
            lastActivity = activitiesListFromFile.get(activitiesListFromFile.size()-1);
            lastActivityTextView.setText(lastActivity.toString());
        }


        fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();

        activitiesCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navView.setCheckedItem(R.id.nav_activities);
                fragmentTransaction.replace(R.id.fragment_container, new ActivitiesFragment());
                fragmentTransaction.commit();
            }
        });

        reminderCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                navView.setCheckedItem(R.id.nav_reminder);
                fragmentTransaction.replace(R.id.fragment_container, new ReminderFragment());
                fragmentTransaction.commit();
            }
        });


        return mainRootView;
    }

    private ArrayList<Reminder> readRemindersFromFile(){
        ArrayList<com.beter.timehole.core.Reminder> remindersFromFile = new ArrayList<>();
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
