/**
 * Created by Ebrar on 08/12/15.
 */
package com.beter.timehole.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.beter.timehole.R;
import com.beter.timehole.core.Activity;

import java.util.ArrayList;

public class HelpFragment extends Fragment {

    public HelpFragment() {
    }

    ListView helpList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.help_fragment, container, false);
        ListView helpList = (ListView) this.getActivity().findViewById(R.id.helpList);
        String[] list = {"How to Use?", "FAQ", "End-User License Agreement", "Troubleshooting", "Send Feedback", "About us"};
        ArrayAdapter<String> aa = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, android.R.id.text1, list);
        helpList.setAdapter(aa);

        helpList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String help = String.valueOf(parent.getItemAtPosition(position));
                // seçilince olacaklar için metodlar burada olacak
            }
        });

        return view;
    }
}






















