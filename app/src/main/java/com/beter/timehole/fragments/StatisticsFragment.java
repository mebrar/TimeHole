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

import java.util.ArrayList;


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

        String[] codename = {"KitKat", "Jelly Bean", "Ice Cream Sandwich", "Gingerbread", "Froyo"};

        double[] values = {13.6, 58.4, 12.3, 14.9, 0.8 };
        String[] colors = {"#ff4444", "#99cc00", "#aa66cc", "#33b5e5", "#ffbb33"};


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




