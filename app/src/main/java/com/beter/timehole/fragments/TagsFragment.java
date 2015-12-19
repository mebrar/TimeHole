/**
 * Created by Ebrar on 08/12/15.
 */
package com.beter.timehole.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import com.beter.timehole.core.Tag;

import com.beter.timehole.R;

public class TagsFragment extends Fragment {

    public TagsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View tagsRootView = inflater.inflate(R.layout.tags_fragment, container, false);
        Tag sleep= new Tag("Sleep");
        Tag eating= new Tag("Eating");
        Tag study= new Tag("Study");
        Tag free_time= new Tag("Free Time");
        Tag house_work= new Tag("House Work");
        Tag hobby= new Tag("Hobby");
        Tag[] tags = {sleep, eating, study, free_time, house_work, hobby};

        ListView tagsList = (ListView) tagsRootView.findViewById(R.id.tagsListView);
        tagsList.setAdapter(new ArrayAdapter(getActivity(), R.layout.support_simple_spinner_dropdown_item, tags));

        return tagsRootView;
    }




}
