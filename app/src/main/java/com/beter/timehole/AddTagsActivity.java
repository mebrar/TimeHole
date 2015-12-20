package com.beter.timehole;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View.OnClickListener;
import android.view.View;

import com.beter.timehole.core.Tag;
import com.beter.timehole.fragments.SetTagDialogFragment;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class AddTagsActivity extends AppCompatActivity {

    private Button dfragbutton;
    private FragmentManager fm = getSupportFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tags);


        dfragbutton = (Button) findViewById(R.id.dfragbutton);

        dfragbutton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                SetTagDialogFragment dFragment = new SetTagDialogFragment();
               // Show DialogFragment
               // SetTagDialogFragment.show(fm,"Dialog Fragment");
            }
        });

    }

    private void writeTagToFile(ArrayList<Tag> tagsCont) {
        try {
            FileOutputStream tagFileOutputStream = this.openFileOutput("tagobjects.dat", Context.MODE_WORLD_READABLE);
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
            FileInputStream tagFileInputStream = this.openFileInput("tagobjects.dat");
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
