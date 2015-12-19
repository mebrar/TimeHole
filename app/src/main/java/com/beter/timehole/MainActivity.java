package com.beter.timehole;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.*;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.content.Context;
import android.widget.Button;

import com.beter.timehole.fragments.ActivitiesFragment;
import com.beter.timehole.fragments.HelpFragment;
import com.beter.timehole.fragments.MainFragment;
import com.beter.timehole.fragments.ReminderFragment;
import com.beter.timehole.fragments.StatisticsFragment;
import com.beter.timehole.fragments.TagsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    static FragmentManager fragment_manager;
    static Toolbar toolbar;
    static NavigationView navigationView;
    static FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        MainFragment mainScreenFragment = new MainFragment();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, mainScreenFragment);
        fragmentTransaction.commit();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            Intent settingsInflater = new Intent(this, SettingsActivity.class);
            startActivity(settingsInflater);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        fragment_manager = getFragmentManager();
        fragmentTransaction = getSupportFragmentManager().beginTransaction();

        int id = item.getItemId();

        if (id == R.id.nav_home) {
            MainFragment mainScreenFragment = new MainFragment();
            fragmentTransaction.replace(R.id.fragment_container, mainScreenFragment);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_activities) {
            ActivitiesFragment activitiesScreenFragment = new ActivitiesFragment();
            fragmentTransaction.replace(R.id.fragment_container, activitiesScreenFragment);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_reminder) {
            ReminderFragment reminderScreenFragment = new ReminderFragment();
            fragmentTransaction.replace(R.id.fragment_container, reminderScreenFragment);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_statistics) {
            StatisticsFragment statisticsScreenFragment = new StatisticsFragment();
            fragmentTransaction.replace(R.id.fragment_container, statisticsScreenFragment);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_tags) {
            TagsFragment tagsScreenFragment = new TagsFragment();
            fragmentTransaction.replace(R.id.fragment_container, tagsScreenFragment);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_help) {
            HelpFragment helpScreenFragment = new HelpFragment();
            fragmentTransaction.replace(R.id.fragment_container, helpScreenFragment);
            fragmentTransaction.commit();
        }
        else if (id == R.id.nav_settings) {
            Intent settingsInflater = new Intent(this, SettingsActivity.class);
            startActivity(settingsInflater);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}