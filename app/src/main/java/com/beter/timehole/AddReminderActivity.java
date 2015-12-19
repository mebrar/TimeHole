package com.beter.timehole;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.widget.TimePicker;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Calendar;

import com.beter.timehole.core.Reminder;
import com.rey.material.widget.EditText;


public class AddReminderActivity extends AppCompatActivity {

    EditText datePickerInput;
    EditText timePickerInput;
    static final int DATE_DIALOG_ID = 0;
    static final int TIME_DIALOG_ID = 1;
    private int dateYear;
    private int dateMonth;
    private int dateDay;
    private int timeHour;
    private int timeMinute;

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
            FileOutputStream reminderFileOutputStream = this.openFileOutput("reminderObjects", Context.MODE_PRIVATE);
            ObjectOutputStream reminderObjectStream = new ObjectOutputStream(reminderFileOutputStream);
            reminderObjectStream.writeObject(reminder);
            reminderObjectStream.close();
            reminderFileOutputStream.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
