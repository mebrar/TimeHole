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
import android.widget.Button;
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
        ImageView lastImage=(ImageView) view.findViewById(R.id.imageView2);
        Button button = (Button) view.findViewById(R.id.deleteButton);


        tagText.setText(singleTagItem.getTagName());
        if(singleTagItem.getColor() == Tag.blueGrey)
            lastImage.setImageResource(R.drawable.blue_grey);
        else if(singleTagItem.getColor() == Tag.brownColor)
            lastImage.setImageResource(R.drawable.brown);
        else  if(singleTagItem.getColor() == Tag.darkBlue)
            lastImage.setImageResource(R.drawable.deepblue);
        else if(singleTagItem.getColor() == Tag.deepPurple)
            lastImage.setImageResource(R.drawable.deeppurple);
        else if(singleTagItem.getColor() == Tag.greenColor)
            lastImage.setImageResource(R.drawable.green);
        else if(singleTagItem.getColor() == Tag.lightBlue)
            lastImage.setImageResource(R.drawable.lblue);
        else if(singleTagItem.getColor() == Tag.orangeColor)
            lastImage.setImageResource(R.drawable.orange);
        else if(singleTagItem.getColor() == Tag.pinkColor)
            lastImage.setImageResource(R.drawable.pink);
        else if(singleTagItem.getColor() == Tag.purpleColor)
            lastImage.setImageResource(R.drawable.purple);
        else if(singleTagItem.getColor() == Tag.redColor)
            lastImage.setImageResource(R.drawable.red);
        else  if(singleTagItem.getColor() == Tag.tealColor)
            lastImage.setImageResource(R.drawable.teal);
        else  if(singleTagItem.getColor() == Tag.yellowColor)
            lastImage.setImageResource(R.drawable.yellow);
        else
            lastImage.setImageResource(R.drawable.ic_bookmark_black_24dp);
        if(singleTagItem.getTagName().equals("Sleep")){
            tagImage.setImageResource(R.drawable.ic_hotel_black_24dp);
        }

        else if(singleTagItem.getTagName().equals("Eating")){
            tagImage.setImageResource(R.drawable.ic_local_restaurant_black_24dp);
        }

        else if(singleTagItem.getTagName().equals("Study")){
            tagImage.setImageResource(R.drawable.ic_border_color_black_24dp);
        }

        else if(singleTagItem.getTagName().equals("Free Time")){
            tagImage.setImageResource(R.drawable.ic_headset_black_24dp);
        }

        else if(singleTagItem.getTagName().equals("House Work")){
            tagImage.setImageResource(R.drawable.ic_home_black_24dp);
        }

        else if(singleTagItem.getTagName().equals("Hobby")){
            tagImage.setImageResource(R.drawable.ic_color_lens_black_24dp);
        }
        else{
            tagImage.setImageResource(R.drawable.ic_bookmark_black_24dp);
        }
        final int Position = position;
        button.setOnClickListener(new View.OnClickListener() {
                                      public void onClick(View v) {
                                          list.remove(Position);
                                          notifyDataSetChanged();
                                          //dataFromFile = readActivitiesFromFile();
                                          //dataFromFile.remove(position);
                                          //writeActivityToFile(dataFromFile);
                                      }
                                  }
        );
        return view;

    }
}
