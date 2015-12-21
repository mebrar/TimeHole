package com.beter.timehole.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ListAdapter;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.beter.timehole.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by taha on 18.12.2015.
 */
public class MyCustomAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<com.beter.timehole.core.Activity> list = new ArrayList<com.beter.timehole.core.Activity>();
    private Context context;

    public MyCustomAdapter(ArrayList<com.beter.timehole.core.Activity> list, Context context) {
        this.list = list;
        this.context = context;
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int pos) {
        return list.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.custom_listview_element, null);
        }
        TextView listItemText = (TextView)view.findViewById(R.id.list_item_string);
        listItemText.setText(list.get(position).toString());
        /**
         * Takes the current item converts to string and puts in the current order in the list.
         */
        final CheckBox checkbox = (CheckBox) view.findViewById(R.id.doneCheckBox);
        final Button button = (Button) view.findViewById(R.id.button);
        final int Position = position;
        if(list.get(position).isDone()) {
            checkbox.setChecked(true);
            checkbox.setText("Done");
        }
        else {
            checkbox.setChecked(false);
            checkbox.setText("Undone");
        }

       button.setOnClickListener(new View.OnClickListener() {
                                     public void onClick(View arg0) {
                                         list.remove(Position);
                                     }
                                 }
       );

        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                                                @Override
                                                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                                                    String text="";
                                                    list.get(Position).setDone(checkbox.isChecked());//Changes the value of the activity object's boolean
                                                    if(checkbox.isChecked())
                                                        checkbox.setText("Done");
                                                    else
                                                        checkbox.setText("Undone");
                                                    // perform logic
                                                }
            }

        );





        return view;
    }
}
