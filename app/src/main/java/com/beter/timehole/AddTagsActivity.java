package com.beter.timehole;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.ImageView;

import com.beter.timehole.core.Tag;
import com.rey.material.widget.EditText;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class AddTagsActivity extends AppCompatActivity {

    private Button dfragbutton;
    private EditText tagNameInput;
    public static int clickedColor = Color.BLACK;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_tags);

        ImageView redTag = (ImageView) findViewById(R.id.redImage);
        redTag.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                clickedColor = Tag.redColor;
            }
        });
        ImageView yellowTag = (ImageView) findViewById(R.id.yellowImage);
        yellowTag.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                clickedColor = Tag.yellowColor;
            }
        });
        ImageView pinkTag = (ImageView) findViewById(R.id.pinkImage);
        pinkTag.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                clickedColor = Tag.pinkColor;
            }
        });
        ImageView brownTag = (ImageView) findViewById(R.id.brownImage);
        brownTag.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                clickedColor = Tag.brownColor;
            }
        });
        ImageView tealTag = (ImageView) findViewById(R.id.tealImage);
        tealTag.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                clickedColor = Tag.tealColor;
            }
        });
        ImageView lightBlueTag = (ImageView) findViewById(R.id.lightBlueImage);
        lightBlueTag.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                clickedColor = Tag.lightBlue;
            }
        });
        ImageView deepPurpleTag = (ImageView) findViewById(R.id.deepPurpleImage);
        deepPurpleTag.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                clickedColor = Tag.deepPurple;
            }
        });
        ImageView darkBlueTag = (ImageView) findViewById(R.id.darkBlueImage);
        darkBlueTag.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                clickedColor = Tag.darkBlue;
            }
        });
        ImageView greenTag = (ImageView) findViewById(R.id.greenImage);
        greenTag.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                clickedColor = Tag.greenColor;
            }
        });
        ImageView blueGreyTag = (ImageView) findViewById(R.id.blueGreyImage);
        blueGreyTag.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                clickedColor = Tag.blueGrey;
            }
        });
        ImageView purpleTag = (ImageView) findViewById(R.id.purpleImage);
        purpleTag.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                clickedColor = Tag.purpleColor;
            }
        });
        ImageView orangeTag = (ImageView) findViewById(R.id.orangeImage);
        orangeTag.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                clickedColor = Tag.orangeColor;
            }
        });



        dfragbutton = (Button) findViewById(R.id.dfragbutton);
        final Intent tagsBackIntent = new Intent(this, MainActivity.class);

        dfragbutton.setOnClickListener(new OnClickListener() {
            public void onClick(View arg0) {
                tagNameInput = (EditText)(findViewById(R.id.tag_name_input));
                String tagName = tagNameInput.getText().toString();
                Tag newTag = new Tag(tagName, clickedColor);
                ArrayList<Tag> tempTagsContainer = readTagsFromFile();
                tempTagsContainer.add(newTag);
                writeTagToFile(tempTagsContainer);
                String fragmName = "tag";
                tagsBackIntent.putExtra("nav_item", fragmName);
                startActivity(tagsBackIntent);
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
