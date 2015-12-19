package com.beter.timehole;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import android.util.Log;

import com.beter.timehole.core.Reminder;
import com.rey.material.widget.EditText;


public class AddReminderActivity extends AppCompatActivity {

    EditText datePickerInput;
    EditText timePickerInput;
    EditText nameInput;
    EditText noteInput;
    static final int DATE_DIALOG_ID = 0;
    static final int TIME_DIALOG_ID = 1;
    private int dateYear;
    private int dateMonth;
    private int dateDay;
    private int timeHour;
    private int timeMinute;
    public static int reminderCount = 0;
    private static final String TAG = "checkControl";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final Calendar cal = Calendar.getInstance();
        dateYear = cal.get(Calendar.YEAR);
        dateMonth = cal.get(Calendar.MONTH);
        dateDay = cal.get(Calendar.DAY_OF_MONTH);

        setContentView(R.layout.activity_add_reminder);
    }

    public void datePickerClicked(View v){
        showDialog(DATE_DIALOG_ID);
    }

    public void timePickerClicked(View v){
        showDialog(TIME_DIALOG_ID);
    }

    @Override
    protected Dialog onCreateDialog(int id){
        if(id == DATE_DIALOG_ID){
            return new DatePickerDialog(this,datePickerListener, dateYear,dateMonth,dateDay);
        }
        else if(id == TIME_DIALOG_ID){
            return new TimePickerDialog(this,timePickerListener,timeHour,timeMinute,true);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener datePickerListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            dateYear = year;
            dateMonth = monthOfYear +1;
            dateDay = dayOfMonth;
            Toast.makeText(AddReminderActivity.this,dateYear + "/" + dateMonth + "/"+dateDay,Toast.LENGTH_LONG).show();
            updateDatePickerText();
        }
    };

    private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            timeHour = hourOfDay;
            timeMinute = minute;
            Toast.makeText(AddReminderActivity.this,timeHour + ":" +timeMinute,Toast.LENGTH_LONG).show();
            updateTimePickerText();
        }
    };

    private void updateDatePickerText(){
        datePickerInput = (EditText)findViewById(R.id.reminder_date_input);
        datePickerInput.setText(dateYear + "/" + dateMonth + "/"+dateDay);
    }

    private void updateTimePickerText(){
        timePickerInput = (EditText)findViewById(R.id.reminder_time_input);
        timePickerInput.setText(timeHour + ":" +timeMinute);
    }

    private void writeReminderToFile(Reminder reminder) {
        try {
            Log.i(TAG, "WriteFile Step");
            FileOutputStream reminderFileOutputStream = this.openFileOutput("reminderobjects.dat", Context.MODE_WORLD_READABLE);
            ObjectOutputStream reminderObjectStream = new ObjectOutputStream(reminderFileOutputStream);
            reminderObjectStream.writeObject(reminder);
            reminderCount++;
            reminderObjectStream.close();
            reminderFileOutputStream.close();
        }
        catch(Exception e){
            Log.i(TAG, "WriteFile Catch Step");
            e.printStackTrace();
        }
    }


    public void addReminderClicked(View v){
        nameInput = (EditText)findViewById(R.id.reminder_name_input);
        noteInput = (EditText)findViewById(R.id.reminder_note_input);
        String reminderName = nameInput.getText().toString();
        String reminderNote = noteInput.getText().toString();
        Reminder reminder = new Reminder(new Date(dateYear,dateMonth,dateDay,timeHour,timeMinute), reminderName,reminderNote,null,null);
        writeReminderToFile(reminder);
        Log.i(TAG, "Pressed and Wrote Step");
        onBackPressed();
    }
}
