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

    public ReminderFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View reminderRootView = inflater.inflate(R.layout.reminder_fragment, container, false);
        ArrayList<Tag> tags1= new ArrayList<Tag>();
        tags1.add(new Tag("Calisma"));


        reminderArrayList = readRemindersFromFile();

        ListView reminderlist = (ListView) reminderRootView.findViewById(R.id.listView);

        reminderlist.setAdapter(new ArrayAdapter<com.beter.timehole.core.Reminder>(getActivity(),
                android.R.layout.simple_list_item_1, reminderArrayList));

        Button addReminderButton = (Button) reminderRootView.findViewById(R.id.reminderbutton);
        addReminderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), AddReminderActivity.class);
                startActivity(i);
            }
        });
        return reminderRootView;
    }


    private ArrayList<com.beter.timehole.core.Reminder> readRemindersFromFile(){
        ArrayList<com.beter.timehole.core.Reminder> remindersFromFile = new ArrayList<>();
        try{
            FileInputStream reminderFileInputStream = getContext().openFileInput("reminderobjects.dat");
            Log.i(TAG,"First Step");
            ObjectInputStream reminderObjectInputStream = new ObjectInputStream(reminderFileInputStream);

            com.beter.timehole.core.Reminder reminder;
            for(int count = 0; count < AddReminderActivity.reminderCount; count++) {
                reminder = (com.beter.timehole.core.Reminder) reminderObjectInputStream.readObject();
                remindersFromFile.add(reminder);
            }

            reminderObjectInputStream.close();
            reminderFileInputStream.close();
        }
        catch (Exception e){
            Log.i(TAG,"Catch Step");
            e.printStackTrace();
        }
        return remindersFromFile;
    }

}
