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


import com.beter.timehole.*;
import com.beter.timehole.fragments.*;
import com.beter.timehole.R;

public class MainFragment extends Fragment {

    static FragmentTransaction fragmentTransaction;

    public MainFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mainRootView = inflater.inflate(R.layout.main_fragment, container, false);

        return mainRootView;
    }

    public void activitiesCardClicked(View v){
        fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new ActivitiesFragment());
        fragmentTransaction.commit();
    }

    public void reminderCardClicked(View v){
        fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, new ReminderFragment());
        fragmentTransaction.commit();
    }

}
