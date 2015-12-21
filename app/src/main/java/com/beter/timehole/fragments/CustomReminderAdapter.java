package com.beter.timehole.fragments;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.beter.timehole.R;
import com.beter.timehole.core.Activity;
import com.beter.timehole.core.Reminder;

import java.util.ArrayList;

/**
 * Created by taha on 21.12.2015.
 */
public class CustomReminderAdapter extends BaseAdapter implements ListAdapter {
    private ArrayList<com.beter.timehole.core.Reminder> list = new ArrayList<com.beter.timehole.core.Reminder>();
    private Context context;

    public CustomReminderAdapter(ArrayList<com.beter.timehole.core.Reminder> list, Context context) {
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
            view = inflater.inflate(R.layout.custom_reminder_element, null);
        }
        TextView listItemText = (TextView)view.findViewById(R.id.textView2);
        listItemText.setText(list.get(position).toString());
        final Button button = (Button) view.findViewById(R.id.deleteButton);

        final int Position = position;

        button.setOnClickListener(new View.OnClickListener() {
                                      public void onClick(View v) {
                                          list.remove(Position);
                                          notifyDataSetChanged();
                                      }
                                  }
        );
        return view;
        }
}
