/**
 * Created by Ebrar on 08/12/15.
 */
package com.beter.timehole.fragments;

import android.app.FragmentTransaction;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.app.FragmentTransaction;

import com.beter.timehole.MainActivity;
import com.beter.timehole.R;
import com.beter.timehole.core.Activity;
import com.beter.timehole.helpActivities.*;

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

        helpList.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        if (position == 0) {
                            Intent h2u = new Intent(getActivity(), HowToUseActivity.class);
                            startActivity(h2u);
                        } else if (position == 1) {
                            Intent faq = new Intent(getActivity(), FAQActivity.class);
                            startActivity(faq);
                        } else if (position == 2) {
                            Intent eula = new Intent(getActivity(), EULAActivity.class);
                            startActivity(eula);
                        } else if (position == 3) {
                            Intent ts = new Intent(getActivity(), TroubleshootingActivity.class);
                            startActivity(ts);
                        } else if (position == 4) {
                            Intent sf = new Intent(getActivity(), SendFeedbackActivity.class);
                            startActivity(sf);
                        } else if (position == 5) {
                            Intent au = new Intent(getActivity(), AboutUsActivity.class);
                            startActivity(au);
                        }
                    }
                }
        );

        return helpRootView;
    }
}
