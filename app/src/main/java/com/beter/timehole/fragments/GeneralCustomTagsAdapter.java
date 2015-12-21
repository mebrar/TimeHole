package com.beter.timehole.fragments;

/**
 * Created by rumeyzadincer on 19/12/15.
 */

import com.beter.timehole.core.Activity;
import com.beter.timehole.core.Reminder;
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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class GeneralCustomTagsAdapter extends BaseAdapter implements ListAdapter {

    private ArrayList<Tag> list = new ArrayList<Tag>();
    private Context context;
    ArrayList<Tag> dataFromFile = new ArrayList<>();


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

    public View getView(final int position, View convertView, ViewGroup parent) {
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
            button.setVisibility(Button.INVISIBLE);
        }

        else if(singleTagItem.getTagName().equals("Eating")){
            tagImage.setImageResource(R.drawable.ic_local_restaurant_black_24dp);
            button.setVisibility(Button.INVISIBLE);
        }

        else if(singleTagItem.getTagName().equals("Study")){
            tagImage.setImageResource(R.drawable.ic_border_color_black_24dp);
            button.setVisibility(Button.INVISIBLE);
        }

        else if(singleTagItem.getTagName().equals("Free Time")){
            tagImage.setImageResource(R.drawable.ic_headset_black_24dp);
            button.setVisibility(Button.INVISIBLE);
        }

        else if(singleTagItem.getTagName().equals("House Work")){
            tagImage.setImageResource(R.drawable.ic_home_black_24dp);
            button.setVisibility(Button.INVISIBLE);
        }

        else if(singleTagItem.getTagName().equals("Hobby")){
            tagImage.setImageResource(R.drawable.ic_color_lens_black_24dp);
            button.setVisibility(Button.INVISIBLE);
        }
        else{
            tagImage.setImageResource(R.drawable.ic_bookmark_black_24dp);
            button.setVisibility(Button.VISIBLE);
        }
        final int Position = position;
        button.setOnClickListener(new View.OnClickListener() {
                                      public void onClick(View v) {
                                          list.remove(Position);
                                          notifyDataSetChanged();
                                          dataFromFile = readTagsFromFile();
                                          dataFromFile.remove(position-6);
                                          writeTagToFile(dataFromFile);
                                      }
                                  }
        );
        return view;

    }

    private void writeTagToFile(ArrayList<Tag> tagsCont) {
        try {
            FileOutputStream tagFileOutputStream = context.openFileOutput("tagobjects.dat", Context.MODE_WORLD_READABLE);
            ObjectOutputStream tagObjectOutputStream = new ObjectOutputStream(tagFileOutputStream);
            tagObjectOutputStream.writeObject(tagsCont);
            tagObjectOutputStream.close();
            tagFileOutputStream.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private ArrayList<Tag> readTagsFromFile(){
        ArrayList<Tag> tagsFromFile = new ArrayList<>();
        try{
            FileInputStream tagFileInputStream = context.openFileInput("tagobjects.dat");
            ObjectInputStream tagObjectInputStream = new ObjectInputStream(tagFileInputStream);
            tagsFromFile = (ArrayList<Tag>)tagObjectInputStream.readObject();
            tagObjectInputStream.close();
            tagFileInputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return tagsFromFile;
    }
}
