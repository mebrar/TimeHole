package com.beter.timehole;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.beter.timehole.core.Reminder;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;


public class AddActivityActivity extends AppCompatActivity {
    private static EditText nameText;
    private static EditText duration;
    private static EditText startDate;
    private static EditText finishDate;
    private static CheckBox done;
    private static EditText note;

    com.rey.material.widget.EditText datePickerInput;
    com.rey.material.widget.EditText timePickerInput;
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
        setContentView(R.layout.activity_add_activity);


        nameText = (EditText) findViewById(R.id.nameInput);
        duration = (EditText) findViewById(R.id.durationInput);
        startDate = (EditText) findViewById(R.id.startDateInput);
        finishDate = (EditText) findViewById(R.id.finishDateInput);
        note = (EditText) findViewById(R.id.noteInput);
        done = (CheckBox) findViewById(R.id.doneInput);
        final Button createButton = (Button) findViewById(R.id.createButton);
        final boolean doneValue= done.isChecked();// if checkBox done is checked doneValue is set to true and vice versa.
        final long durationValue = Long.parseLong(duration.getText().toString()); 


        /** Another possible way for parsing a string in to a long is:
         * long durationValue = Long.valueOf(duration.getText().toString()).longValue();
         * Thus it can also be used in case there are problems with this solution.
         *
         * In order the doneValue and durationValue to be used in the button listener they must be declared as final that is why their type is final.
         */

        Context context = getApplicationContext();
        CharSequence text = "Activity Created";
        int duration = Toast.LENGTH_SHORT;

        final Toast toast = Toast.makeText(context, text, duration);


        createButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v){
                    com.beter.timehole.core.Activity newActivity = new com.beter.timehole.core.Activity(nameText.getText().toString(),doneValue,durationValue,startDate.getText().toString(),finishDate.getText().toString(),null,note.getText().toString());
                    toast.show();
                }
        }
        );

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
            Toast.makeText(AddActivityActivity.this,dateYear + "/" + dateMonth + "/"+dateDay,Toast.LENGTH_LONG).show();
            updateDatePickerText();
        }
    };

    private TimePickerDialog.OnTimeSetListener timePickerListener = new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            timeHour = hourOfDay;
            timeMinute = minute;
            Toast.makeText(AddActivityActivity.this,timeHour + ":" +timeMinute,Toast.LENGTH_LONG).show();
            updateTimePickerText();
        }
    };

    private void updateDatePickerText(){
        datePickerInput = (com.rey.material.widget.EditText)findViewById(R.id.reminder_date_input);
        datePickerInput.setText(dateYear + "/" + dateMonth + "/"+dateDay);
    }

    private void updateTimePickerText(){
        timePickerInput = (com.rey.material.widget.EditText)findViewById(R.id.reminder_time_input);
        timePickerInput.setText(timeHour + ":" +timeMinute);
    }


    private void writeActivityToFile(com.beter.timehole.core.Activity activity) {
        try {
            FileOutputStream activityFileOutputStream = this.openFileOutput("ActivityObjects", Context.MODE_PRIVATE);
            ObjectOutputStream activityObjectOutputStream = new ObjectOutputStream(activityFileOutputStream);
            activityObjectOutputStream.writeObject(activity);
            activityObjectOutputStream.close();
            activityFileOutputStream.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}
