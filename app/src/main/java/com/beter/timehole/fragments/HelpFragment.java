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
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.beter.timehole.R;
import com.beter.timehole.core.Activity;

public class HelpFragment extends Fragment {

    public HelpFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View helpRootView = inflater.inflate(R.layout.help_fragment, container, false);

        String[] list = {"How to Use?", "FAQ", "End-User License Agreement", "Troubleshooting", "Send Feedback", "AboutUs"};
        ListView helpList = (ListView) helpRootView.findViewById(R.id.helpList);
        helpList.setAdapter(new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, list));

        return helpRootView;
    }
}
