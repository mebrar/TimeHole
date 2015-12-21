/**
 * Created by Ebrar on 08/12/15.
 */
package com.beter.timehole.fragments;
import com.beter.timehole.core.Tag;
import com.beter.timehole.AddTagsActivity;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.Button;
import com.beter.timehole.core.Tag;
import android.content.Intent;



import com.beter.timehole.R;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class TagsFragment extends Fragment {

    ArrayList<Tag> tagsContainer = new ArrayList<>();

    public TagsFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View tagsRootView = inflater.inflate(R.layout.tags_fragment, container, false);
        Tag sleep= new Tag("Sleep");
        Tag eating= new Tag("Eating");
        Tag study= new Tag("Study");
        Tag free_time= new Tag("Free Time");
        Tag house_work= new Tag("House Work");
        Tag hobby= new Tag("Hobby");
        tagsContainer.add(sleep);
        tagsContainer.add(eating);
        tagsContainer.add(study);
        tagsContainer.add(free_time);
        tagsContainer.add(house_work);
        tagsContainer.add(hobby);
        ArrayList<Tag> addedTags = new ArrayList<Tag>();
       // tagsContainer = readTagsFromFile();
        for(int i= 0 ; i < readTagsFromFile().size(); i++){
            addedTags.add( readTagsFromFile().get(i));
        }

        ListView tagsList = (ListView) tagsRootView.findViewById(R.id.tagsListView);
        addedTags.add(new Tag("rümeyza"));

        for(int i = 0 ; i < addedTags.size(); i++){
            tagsContainer.add(addedTags.get(i));
        }


        tagsList.setAdapter(new GeneralCustomTagsAdapter(tagsContainer, getActivity()));

        Button tagButton = (Button) tagsRootView.findViewById(R.id.addTagButton);
        tagButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getActivity(), AddTagsActivity.class);
                startActivity(i);
            }
        });
        return tagsRootView;
    }

    private ArrayList<Tag> readTagsFromFile(){
        ArrayList<Tag> tagsFromFile = new ArrayList<>();
        try{
            FileInputStream tagFileInputStream = getContext().openFileInput("tagobjects.dat");
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
    
    private void writeTagToFile(ArrayList<Tag> tagsCont) {
        try {
            FileOutputStream tagFileOutputStream = getContext().openFileOutput("tagobjects.dat", Context.MODE_WORLD_READABLE);
            ObjectOutputStream tagObjectOutputStream = new ObjectOutputStream(tagFileOutputStream);
            tagObjectOutputStream.writeObject(tagsCont);
            tagObjectOutputStream.close();
            tagFileOutputStream.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
