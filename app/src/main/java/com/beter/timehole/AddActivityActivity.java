package com.beter.timehole;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.beter.timehole.core.Activity;
import com.beter.timehole.core.Tag;
import com.rey.material.widget.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import android.util.Log;
import com.rey.material.widget.Spinner;


public class AddActivityActivity extends AppCompatActivity {

    private static EditText duration;

    com.rey.material.widget.EditText startDatePickerInput;
    com.rey.material.widget.EditText startTimePickerInput;
    com.rey.material.widget.EditText finishDatePickerInput;
    com.rey.material.widget.EditText finishTimePickerInput;
    com.rey.material.widget.CheckBox doneInput;

    static final int START_DATE_DIALOG_ID = 0;
    static final int FINISH_DATE_DIALOG_ID = 1;
    static final int START_TIME_DIALOG_ID = 2;
    static final int FINISH_TIME_DIALOG_ID = 3;



    private int startDateYear;
    private int startDateMonth;
    private int startDateDay;
    private int startTimeHour;
    private int startTimeMinute;

    private int finishDateYear;
    private int finishDateMonth;
    private int finishDateDay;
    private int finishTimeHour;
    private int finishTimeMinute;

    private static final String TAG = "asfg";

    private ArrayList<Activity> activitiesContainer = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        final Calendar cal = Calendar.getInstance();
        startDateYear = cal.get(Calendar.YEAR);
        startDateMonth = cal.get(Calendar.MONTH);
        startDateDay = cal.get(Calendar.DAY_OF_MONTH);

        finishDateYear = startDateYear;
        finishDateMonth = startDateMonth;
        finishDateDay = startDateDay;



        setContentView(R.layout.activity_add_activity);

        Spinner tagSelect = (Spinner)findViewById(R.id.tag_select_spinner);


        ArrayList<Tag> tagsContainer = new ArrayList<>();
        Tag sleep= new Tag("Sleep",Tag.redColor);
        Tag eating= new Tag("Eating",Tag.greenColor);
        Tag study= new Tag("Study",Tag.brownColor);
        Tag free_time= new Tag("Free Time",Tag.orangeColor);
        Tag house_work= new Tag("House Work",Tag.pinkColor);
        Tag hobby= new Tag("Hobby",Tag.purpleColor);
        tagsContainer.add(sleep);
        tagsContainer.add(eating);
        tagsContainer.add(study);
        tagsContainer.add(free_time);
        tagsContainer.add(house_work);
        tagsContainer.add(hobby);

        ArrayList<Tag> fileTagsContainer = readTagsFromFile();
        for(int i = 0 ; i < fileTagsContainer.size(); i++){
            tagsContainer.add(fileTagsContainer.get(i));
        }

        Tag[] arrayTagContainer = new Tag[tagsContainer.size()];
        for(int index = 0; index < arrayTagContainer.length; index++){
            arrayTagContainer[index] = tagsContainer.get(index);
        }

        ArrayAdapter<Tag> tagAdapter = new ArrayAdapter<>(this,R.layout.row_spn,arrayTagContainer);
        tagAdapter.setDropDownViewResource(R.layout.row_spn_dropdown);
        tagSelect.setAdapter(tagAdapter);

    }

    public void startDatePickerClicked(View v){
        showDialog(START_DATE_DIALOG_ID);
    }

    public void finishDatePickerClicked(View v){
        showDialog(FINISH_DATE_DIALOG_ID);
    }

    public void startTimePickerClicked(View v){
        showDialog(START_TIME_DIALOG_ID);
    }

    public void finishTimePickerClicked(View v){
        showDialog(FINISH_TIME_DIALOG_ID);
    }

    @Override
    protected Dialog onCreateDialog(int id){
        if(id == START_DATE_DIALOG_ID){
            return new DatePickerDialog(this,startDatePickerListener, startDateYear,startDateMonth,startDateDay);
        }
        else if(id == FINISH_DATE_DIALOG_ID){
            return new DatePickerDialog(this,finishDatePickerListener, finishDateYear,finishDateMonth,finishDateDay);
        }
        else if(id == START_TIME_DIALOG_ID){
            return new TimePickerDialog(this,startTimePickerListener,startTimeHour,startTimeMinute,true);
        }
        else if(id == FINISH_TIME_DIALOG_ID){
            return new TimePickerDialog(this,finishTimePickerListener,finishTimeHour,finishTimeMinute,true);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener startDatePickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            startDateYear = year;
            startDateMonth = monthOfYear +1;
            startDateDay = dayOfMonth;
            Toast.makeText(AddActivityActivity.this,startDateYear + "/" + startDateMonth + "/"+startDateDay,Toast.LENGTH_LONG).show();
            updateStartDatePickerText();
        }
    };

    private TimePickerDialog.OnTimeSetListener startTimePickerListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            startTimeHour = hourOfDay;
            startTimeMinute = minute;
            Toast.makeText(AddActivityActivity.this,startTimeHour + ":" +startTimeMinute,Toast.LENGTH_LONG).show();
            updateStartTimePickerText();
        }
    };

    private DatePickerDialog.OnDateSetListener finishDatePickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            finishDateYear = year;
            finishDateMonth = monthOfYear +1;
            finishDateDay = dayOfMonth;
            Toast.makeText(AddActivityActivity.this,finishDateYear + "/" + finishDateMonth + "/"+finishDateDay,Toast.LENGTH_LONG).show();
            updateFinishDatePickerText();
        }
    };

    private TimePickerDialog.OnTimeSetListener finishTimePickerListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            finishTimeHour = hourOfDay;
            finishTimeMinute = minute;
            Toast.makeText(AddActivityActivity.this,finishTimeHour + ":" +finishTimeMinute,Toast.LENGTH_LONG).show();
            updateFinishTimePickerText();
        }
    };

    private void updateStartDatePickerText(){
        startDatePickerInput = (com.rey.material.widget.EditText)findViewById(R.id.activity_start_date_input);
        startDatePickerInput.setText(startDateDay + "/" + startDateMonth + "/"+startDateYear);
    }

    private void updateStartTimePickerText(){
        startTimePickerInput = (com.rey.material.widget.EditText)findViewById(R.id.activity_start_time_input);
        startTimePickerInput.setText(startTimeHour + ":" +startTimeMinute);
    }

    private void updateFinishDatePickerText(){
        finishDatePickerInput = (com.rey.material.widget.EditText)findViewById(R.id.activity_finish_date_input);
        finishDatePickerInput.setText(finishDateDay + "/" + finishDateMonth + "/"+finishDateYear);
    }

    private void updateFinishTimePickerText(){
        finishTimePickerInput = (com.rey.material.widget.EditText)findViewById(R.id.activity_finish_time_input);
        finishTimePickerInput.setText(finishTimeHour + ":" +finishTimeMinute);
    }


    private void writeActivityToFile(ArrayList<Activity> activityCont) {
        try {
            FileOutputStream activityFileOutputStream = this.openFileOutput("activityobjects.dat", Context.MODE_WORLD_READABLE);
            ObjectOutputStream activityObjectOutputStream = new ObjectOutputStream(activityFileOutputStream);
            activityObjectOutputStream.writeObject(activityCont);
            activityObjectOutputStream.close();
            activityFileOutputStream.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private ArrayList<Activity> readActivitiesFromFile(){
        ArrayList<Activity> activitiesFromFile = new ArrayList<>();
        try{
            FileInputStream activityFileInputStream = this.openFileInput("activityobjects.dat");
            ObjectInputStream activityObjectInputStream = new ObjectInputStream(activityFileInputStream);
            activitiesFromFile = (ArrayList<Activity>)activityObjectInputStream.readObject();
            activityObjectInputStream.close();
            activityFileInputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return activitiesFromFile;
    }

    public void createActivityClicked(View v){
        Date startDate = new Date(startDateYear,startDateMonth,startDateDay,startTimeHour,startTimeMinute);
        Date finishDate = new Date(finishDateYear,finishDateMonth,finishDateDay,finishTimeHour,finishTimeMinute);
        doneInput = (com.rey.material.widget.CheckBox)findViewById(R.id.addActivityDoneInput);
        Spinner tagSelect = (Spinner)findViewById(R.id.tag_select_spinner);
        Tag selectedTag = (Tag)tagSelect.getSelectedItem();
        com.rey.material.widget.EditText activityNameInput = (com.rey.material.widget.EditText)findViewById(R.id.activity_name_input);
        com.rey.material.widget.EditText activityNoteInput = (com.rey.material.widget.EditText)findViewById(R.id.activity_note_input);
        String activityName = activityNameInput.getText().toString();
        String activityNote = activityNoteInput.getText().toString();
        Activity activity = new Activity(activityName,doneInput.isChecked(),startDate,finishDate,selectedTag,activityNote);
        activitiesContainer = readActivitiesFromFile();
        activitiesContainer.add(activity);
        writeActivityToFile(activitiesContainer);
        onBackPressed();
    }


    private ArrayList<Tag> readTagsFromFile(){
        ArrayList<Tag> tagsFromFile = new ArrayList<>();
        try{
            FileInputStream tagFileInputStream = openFileInput("tagobjects.dat");
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
