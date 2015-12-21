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
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Paint.Align;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import org.achartengine.ChartFactory;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;
import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.SeriesSelection;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.ChartFactory;
import org.achartengine.GraphicalView;
import org.achartengine.chart.BarChart.Type;
import org.achartengine.model.CategorySeries;
import org.achartengine.model.XYMultipleSeriesDataset;
import org.achartengine.model.XYSeries;
import org.achartengine.renderer.DefaultRenderer;
import org.achartengine.renderer.SimpleSeriesRenderer;
import org.achartengine.renderer.XYMultipleSeriesRenderer;
import org.achartengine.renderer.XYSeriesRenderer;


import com.beter.timehole.R;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;


public class StatisticsFragment extends Fragment {

    private View mView;
    private GraphicalView mGraphView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.statistics_fragment, container, false);
        mView = rootView;
        initData();
        return rootView;
    }

    private void initData() {
        ArrayList<com.beter.timehole.core.Activity> activitiesArrayList = new ArrayList<>();
        activitiesArrayList  = readActivitiesFromFile();

        ArrayList<String> codename = new ArrayList<>();
        ArrayList<Double> values = new ArrayList<>();
        ArrayList<String> colors = new ArrayList<>();
        for(int i=0;i<activitiesArrayList.size();i++)
        {
            for(int j=0;i<activitiesArrayList.get(i).getTags().size();j++)
            {
                if(codename.contains(activitiesArrayList.get(i).getTags().get(j).getTagName().toString()))
                {
                    int index = codename.indexOf(activitiesArrayList.get(i).getTags().get(j).getTagName().toString());
                    values.set(index,values.get(index)+1);
                }
                else {
                    codename.add(activitiesArrayList.get(i).getTags().get(j).getTagName().toString());
                     int index = codename.indexOf(activitiesArrayList.get(i).getTags().get(j).getTagName().toString());
                     values.set(index, 1.0);
                }
            }
        }
        /**
        for(int i=0;i<activitiesArrayList.size();i++)
        {
            for(int j=0;j<activitiesArrayList.get(i).getTags().size();j++)
            {
                if(colors.contains("#"+activitiesArrayList.get(i).getTags().get(j).getColor()));
                else {
                    colors.add("#" + activitiesArrayList.get(i).getTags().get(j).getColor());
                }
            }
        }
         */
        for(int i=0; i<codename.size();i++)
        {
            int integer =(int) (Math.random()*1000000);
            String color = "#" + integer;
            colors.add(color);
        }

        CategorySeries series = new CategorySeries("Android Platform Version");
        int length = codename.size();
        for (int i = 0; i < length; i++)
            series.add(codename.get(i), values.get(i));

        DefaultRenderer renderer = new DefaultRenderer();
        for (int i = 0; i < length; i++) {
            SimpleSeriesRenderer seriesRenderer = new SimpleSeriesRenderer();
            seriesRenderer.setColor(Color.parseColor(colors.get(i)));
            renderer.addSeriesRenderer(seriesRenderer);

        }

        renderer.setChartTitleTextSize(60);
        renderer.setChartTitle("Android Platform Version");
        renderer.setLabelsTextSize(30);
        renderer.setLabelsColor(Color.GRAY);
        renderer.setLegendTextSize(30);

        drawChart(series, renderer);
    }
    private ArrayList<com.beter.timehole.core.Activity> readActivitiesFromFile(){
        ArrayList<com.beter.timehole.core.Activity> activitiesFromFile = new ArrayList<>();
        try{
            FileInputStream activityFileInputStream = getContext().openFileInput("activityobjects.dat");
            ObjectInputStream activityObjectInputStream = new ObjectInputStream(activityFileInputStream);
            activitiesFromFile = (ArrayList<com.beter.timehole.core.Activity>)activityObjectInputStream.readObject();
            activityObjectInputStream.close();
            activityFileInputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return activitiesFromFile;
    }

    private void drawChart(CategorySeries series, DefaultRenderer renderer) {

        if (null == mGraphView) {
            mGraphView = ChartFactory.getPieChartView(getActivity(), series, renderer);
            RelativeLayout container = (RelativeLayout) mView.findViewById(R.id.graph_container);
            container.addView(mGraphView);
        }
        else
            mGraphView.repaint();
    }
}




