package com.beter.timehole.fragments;

/**
 * Created by rumeyzadincer on 19/12/15.
 */

import com.beter.timehole.core.Activity;
import com.beter.timehole.core.Tag;
import com.beter.timehole.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.widget.BaseAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class GeneralCustomTagsAdapter extends BaseAdapter implements ListAdapter {

    private ArrayList<Tag> list = new ArrayList<Tag>();
    private Context context;


    public GeneralCustomTagsAdapter(ArrayList<Tag> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Tag getItem(int pos) {
        return list.get(pos);
    }
    public long getItemId(int pos) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.general_custom, null);
        }

        Tag singleTagItem =  getItem(position);
        TextView tagText = (TextView) view.findViewById(R.id.tagsText);
        ImageView tagImage= (ImageView) view.findViewById(R.id.tagsImage);


        if(singleTagItem.getTagName().equals("Sleep")){
            tagText.setText(singleTagItem.getTagName());
            tagImage.setImageResource(R.drawable.ic_hotel_black_24dp);
        }

        else if(singleTagItem.getTagName().equals("Eating")){
            tagText.setText(singleTagItem.getTagName());
            tagImage.setImageResource(R.drawable.ic_local_restaurant_black_24dp);
        }


        else if(singleTagItem.getTagName().equals("Study")){
            tagText.setText(singleTagItem.getTagName());
            tagImage.setImageResource(R.drawable.ic_border_color_black_24dp);
        }

        else if(singleTagItem.getTagName().equals("Free Time")){
            tagText.setText(singleTagItem.getTagName());
            tagImage.setImageResource(R.drawable.ic_headset_black_24dp);
        }

        else if(singleTagItem.getTagName().equals("House Work")){
            tagText.setText(singleTagItem.getTagName());
            tagImage.setImageResource(R.drawable.ic_home_black_24dp);
        }

        else if(singleTagItem.getTagName().equals("Hobby")){
            tagText.setText(singleTagItem.getTagName());
            tagImage.setImageResource(R.drawable.ic_color_lens_black_24dp);
        }
        else{
            tagText.setText(singleTagItem.getTagName());
            tagImage.setImageResource(R.drawable.ic_favorite_black_24dp);
        }



        return view;

    }
}
