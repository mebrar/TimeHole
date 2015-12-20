/**
 * Created by Ebrar on 08/12/15.
 */
package com.beter.timehole.fragments;
import com.beter.timehole.core.Tag;
import com.beter.timehole.AddTagsActivity;
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
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class TagsFragment extends Fragment {

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
        ArrayList<Tag> tags = new ArrayList<>();
        tags.add(sleep);
        tags.add(eating);
        tags.add(study);
        tags.add(free_time);
        tags.add(house_work);
        tags.add(hobby);



        ListView tagsList = (ListView) tagsRootView.findViewById(R.id.tagsListView);


        tagsList.setAdapter(new GeneralCustomTagsAdapter(tags, getActivity()));

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

}
