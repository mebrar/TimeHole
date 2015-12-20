package com.beter.timehole.helpActivities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.beter.timehole.R;

public class HowToUseActivity extends AppCompatActivity {

    String h2u = "-The purpose of this app is to track user's activities and show distribution of those on tags which are created by the user.\n" +
            "\n-To create activity, user has to go to the add activity screeen, he has two ways to achieve there: \n" +
            "\t\t\t\t\t1. By pressing on activities card in main screen -> floating action button -> create activity.\n" +
            "\t\t\t\t\t2. By pressing on any floating action button on any screen -> create activity.\n" +
            "\n-To track activities user done so far, he should check statistics screen which is accessible from navigation bar.\n" +
            "\n-To create custom tags, user can use tags screen which is also accessible from navigation bar, or he can use default ones provided.\n" +
            "\n-You can also use reminder feature to set alarms and notifications for events you have created.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_how_to_use);

        TextView h2uText = (TextView) findViewById(R.id.h2uText);
        h2uText.setText(h2u);
    }
}
