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

import java.util.ArrayList;


public class StatisticsFragment extends Fragment {

    public StatisticsFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View statisticsRootView = inflater.inflate(R.layout.statistics_fragment, container, false);


        return statisticsRootView;
    }

}
