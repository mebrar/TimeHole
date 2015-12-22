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
import java.util.Arrays;
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
        ArrayList<com.beter.timehole.core.Activity> activitiesArrayList = new ArrayList<com.beter.timehole.core.Activity>();
        activitiesArrayList  = readActivitiesFromFile();

        ArrayList<String> temp = new ArrayList<String>();
        int tagNumber=0;
        for(int i=0;i<activitiesArrayList.size();i++)
        {
            if(i==0) {
                temp.add(activitiesArrayList.get(i).getTag().getTagName());
                tagNumber ++;
            }
            else if(temp.contains(activitiesArrayList.get(i).getTag().getTagName()))
            {}
            else
            {
                temp.add(activitiesArrayList.get(i).getTag().getTagName());
                tagNumber ++;
            }
        }



        String[] codename = new String[tagNumber];
        Double[] values = new Double[tagNumber];
        String[] colors = new String[tagNumber];
        int j=1;
        for(int i=0;i<activitiesArrayList.size();i++)
        {
                if(j == codename.length)
                    break;
                if(i==0) {
                    codename[0] = activitiesArrayList.get(i).getTag().getTagName();
                    values[0]=1.0;
                }
                else if(Arrays.asList(codename).contains(activitiesArrayList.get(i).getTag().getTagName()))
                {
                    int index = java.util.Arrays.asList(codename).indexOf(activitiesArrayList.get(i).getTag().getTagName());
                    values[index]=values[index]+1;
                }
                else {
                    codename[j] = activitiesArrayList.get(i).getTag().getTagName();
                    int index = java.util.Arrays.asList(codename).indexOf(activitiesArrayList.get(i).getTag().getTagName());
                    values[index]=1.0;
                    j++;
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
        for(int i=0; i<codename.length;i++)
        {
            int integer =(int) (Math.random()*1000000);
            String color = "#" + integer;
            colors[i]= color;
        }

        CategorySeries series = new CategorySeries("Android Platform Version");
        int length = codename.length;
        for (int i = 0; i < length; i++)
            series.add(codename[i], values[i]);

        DefaultRenderer renderer = new DefaultRenderer();
        for (int i = 0; i < length; i++) {
            SimpleSeriesRenderer seriesRenderer = new SimpleSeriesRenderer();
            seriesRenderer.setColor(Color.parseColor(colors[i]));
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




