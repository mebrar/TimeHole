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
import com.beter.timehole.core.Tag;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;

public class ReminderFragment extends Fragment {

    public ReminderFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View reminderRootView = inflater.inflate(R.layout.reminder_fragment, container, false);
        ArrayList<Tag> tags1= new ArrayList<Tag>();
        tags1.add(new Tag("Calisma"));

        com.beter.timehole.core.Reminder reminder1 = new com.beter.timehole.core.Reminder(new Date(18),"sınav1","Part A çalış","sınav saat 6 da",tags1);
        com.beter.timehole.core.Reminder reminder2 = new com.beter.timehole.core.Reminder(new Date(18),"sınav2","Part A çalış","sınav saat 6 da",tags1);
        com.beter.timehole.core.Reminder reminder3 = new com.beter.timehole.core.Reminder(new Date(18),"sınav3","Part A çalış","sınav saat 6 da",tags1);
        com.beter.timehole.core.Reminder reminder4 = new com.beter.timehole.core.Reminder(new Date(18),"sınav4","Part A çalış","sınav saat 6 da",tags1);

        ArrayList<com.beter.timehole.core.Reminder> reminderList = new ArrayList<com.beter.timehole.core.Reminder>();
        reminderList.add(reminder1);
        reminderList.add(reminder2);
        reminderList.add(reminder3);
        reminderList.add(reminder4);

        ListView reminderlist = (ListView) reminderRootView.findViewById(R.id.listView);

        reminderlist.setAdapter(new ArrayAdapter<com.beter.timehole.core.Reminder>(getActivity(),
                android.R.layout.simple_list_item_1, reminderList));

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


}
