package com.beter.timehole;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.app.Activity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class AddActivityActivity extends AppCompatActivity {
    private static EditText nameText;
    private static EditText duration;
    private static EditText startDate;
    private static EditText finishDate;
    private static CheckBox done;
    private static EditText note;

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

        createButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v){
                    com.beter.timehole.core.Activity newActivity = new com.beter.timehole.core.Activity(nameText.getText().toString(),doneValue,durationValue,startDate.getText().toString(),finishDate.getText().toString(),null,note.getText().toString());
                }
        }
        );

    }

}
