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

import android.app.AlarmManager;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import android.util.Log;

import com.beter.timehole.core.Reminder;
import com.rey.material.widget.EditText;


public class AddReminderActivity extends AppCompatActivity {

    EditText datePickerInput;
    EditText timePickerInput;
    static EditText nameInput;
    static EditText noteInput;
    static final int DATE_DIALOG_ID = 0;
    static final int TIME_DIALOG_ID = 1;
    static public int dateYear;
    static public int dateMonth;
    static public int dateDay;
    static  int timeHour;
    static public int timeMinute;
    private ArrayList<Reminder> reminderContainer = new ArrayList<>();
    static Notification.Builder  notification;
    private ScheduleClient scheduleClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_reminder);
        //Creating new service client
        scheduleClient = new ScheduleClient(this);
        scheduleClient.doBindService();

        final Calendar cal = Calendar.getInstance();
        dateYear = cal.get(Calendar.YEAR);
        dateMonth = cal.get(Calendar.MONTH);
        dateDay = cal.get(Calendar.DAY_OF_MONTH);


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
        datePickerInput.setText(dateDay + "/" + dateMonth + "/"+dateYear);
    }

    private void updateTimePickerText(){
        timePickerInput = (EditText)findViewById(R.id.reminder_time_input);
        timePickerInput.setText(timeHour + ":" +timeMinute);
    }

    private void writeReminderToFile(ArrayList<Reminder> reminderCont) {
        try {
            FileOutputStream reminderFileOutputStream = this.openFileOutput("reminderobjects.dat", Context.MODE_WORLD_READABLE);
            ObjectOutputStream reminderObjectStream = new ObjectOutputStream(reminderFileOutputStream);
            reminderObjectStream.writeObject(reminderCont);
            reminderObjectStream.close();
            reminderFileOutputStream.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    private ArrayList<Reminder> readRemindersFromFile(){
        ArrayList<com.beter.timehole.core.Reminder> remindersFromFile = new ArrayList<>();
        try{
            FileInputStream reminderFileInputStream = this.openFileInput("reminderobjects.dat");
            ObjectInputStream reminderObjectInputStream = new ObjectInputStream(reminderFileInputStream);
            remindersFromFile = (ArrayList<Reminder>)reminderObjectInputStream.readObject();
            reminderObjectInputStream.close();
            reminderFileInputStream.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return remindersFromFile;
    }

    public void createReminderClicked(View v){
        nameInput = (EditText)findViewById(R.id.reminder_name_input);
        noteInput = (EditText)findViewById(R.id.reminder_note_input);
        String reminderName = nameInput.getText().toString();
        String reminderNote = noteInput.getText().toString();
        Reminder reminder = new Reminder(new Date(dateYear,dateMonth-1,dateDay,timeHour,timeMinute), reminderName,reminderNote,null,null);
        reminderContainer = readRemindersFromFile();
        Toast.makeText(AddReminderActivity.this,"Reminder Created: " +reminder.getDate().toString(),Toast.LENGTH_LONG).show();
        reminderContainer.add(reminder);
        writeReminderToFile(reminderContainer);



        Calendar calendar = Calendar.getInstance();
        calendar.set(dateYear,dateMonth,dateDay,timeHour,timeMinute);
        calendar.set(Calendar.SECOND,0);

        scheduleClient.setAlarmForNotification(calendar);
        Toast.makeText(this,"Reminder set",Toast.LENGTH_SHORT).show();

        onBackPressed();
    }

    @Override
    protected void onStop() {
        // When our activity is stopped ensure we also stop the connection to the service
        // this stops us leaking our activity into the system *bad*
        if(scheduleClient != null)
            scheduleClient.doUnbindService();
        super.onStop();
    }
}
