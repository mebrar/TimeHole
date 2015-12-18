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


import com.beter.timehole.*;
import com.beter.timehole.R;

public class ReminderFragment extends Fragment {

    public ReminderFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View reminderRootView = inflater.inflate(R.layout.reminder_fragment, container, false);

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
