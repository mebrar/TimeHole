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

import com.beter.timehole.R;

public class ReminderFragment extends Fragment {

    public ReminderFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.reminder_fragment, container, false);
    }
}
