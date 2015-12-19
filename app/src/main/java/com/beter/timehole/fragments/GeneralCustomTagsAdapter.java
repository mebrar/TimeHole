package com.beter.timehole.fragments;

/**
 * Created by rumeyzadincer on 19/12/15.
 */
import com.beter.timehole.core.Tag;
import com.beter.timehole.R;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class GeneralCustomTagsAdapter extends ArrayAdapter<Tag> {


    public GeneralCustomTagsAdapter(Context context, Tag[] tags) {
        super(context,R.layout.general_custom, tags);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater tagsInflater = LayoutInflater.from(getContext());
        View customView = tagsInflater.inflate(R.layout.general_custom, parent, false);

        Tag singleTagItem =  getItem(position);
        TextView tagText = (TextView) customView.findViewById(R.id.tagsText);
        ImageView tagImage= (ImageView) customView.findViewById(R.id.tagsImage);


        if(singleTagItem.getTagName().equals("Sleep")){
            tagText.setText(singleTagItem.getTagName());
            tagImage.setImageResource(R.drawable.ic_hotel_black_24dp);
        }

        if(singleTagItem.getTagName().equals("Eating")){
            tagText.setText(singleTagItem.getTagName());
            tagImage.setImageResource(R.drawable.ic_local_restaurant_black_24dp);
        }


        if(singleTagItem.getTagName().equals("Study")){
            tagText.setText(singleTagItem.getTagName());
            tagImage.setImageResource(R.drawable.ic_border_color_black_24dp);
        }

        if(singleTagItem.getTagName().equals("Free Time")){
            tagText.setText(singleTagItem.getTagName());
            tagImage.setImageResource(R.drawable.ic_headset_black_24dp);
        }

        if(singleTagItem.getTagName().equals("House Work")){
            tagText.setText(singleTagItem.getTagName());
            tagImage.setImageResource(R.drawable.ic_home_black_24dp);
        }

        if(singleTagItem.getTagName().equals("Hobby")){
            tagText.setText(singleTagItem.getTagName());
            tagImage.setImageResource(R.drawable.ic_color_lens_black_24dp);
        }



        return customView;

    }
}
