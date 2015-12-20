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

import com.beter.timehole.AddActivityActivity;
import com.beter.timehole.AddReminderActivity;
import com.beter.timehole.fragments.ReminderFragment;
import com.beter.timehole.R;

public class MainFragment extends Fragment {


    public MainFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View mainRootView = inflater.inflate(R.layout.main_fragment, container, false);




        return mainRootView;
    }
}
