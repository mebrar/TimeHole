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


import com.beter.timehole.*;
import com.beter.timehole.fragments.*;
import com.beter.timehole.R;

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

}
