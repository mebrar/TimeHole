package com.beter.timehole;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rey.material.app.DatePickerDialog;
import com.rey.material.app.Dialog;

import android.support.v7.widget.Toolbar;
import android.view.View;

import com.rey.material.app.TimePickerDialog;
import com.rey.material.widget.EditText;


public class AddReminderActivity extends AppCompatActivity {

    EditText datePickerInput;
    EditText timePickerInput;
    static final int DATE_DIALOG_ID = 0;
    static final int TIME_DIALOG_ID = 1;
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        toolbar = (Toolbar) findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);

        setContentView(R.layout.activity_add_reminder);
    }
/**
    public void


    public void datePickerClicked(View v){
        showDialog(DATE_DIALOG_ID);
    }

    public void timePickerClicked(View v){
        showDialog(TIME_DIALOG_ID);
    }

    @Override
    protected Dialog onCreateDialog(int id){
        if(id == DATE_DIALOG_ID){
            return new DatePickerDialog(this,)
        }
        else if(id == TIME_DIALOG_ID){
            return new TimePickerDialog(this)
        }
        return null;
    }



    private DatePickerDialog.OnDateChangedListener

    */

}
