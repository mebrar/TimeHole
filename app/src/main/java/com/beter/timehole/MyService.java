package com.beter.timehole;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import com.beter.timehole.AddReminderActivity;
import java.util.Calendar;


public class MyService extends Service {

    //private Calendar calendar;
    //private Notification.Builder notification;
    private static final int uniqueID = 426346;

    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {


        Runnable r = new Runnable() {
            @Override
            public void run() {
                Calendar calendar = Calendar.getInstance();
                calendar.set(AddReminderActivity.dateYear,AddReminderActivity.dateMonth,AddReminderActivity.dateDay,AddReminderActivity.timeHour,AddReminderActivity.timeMinute);
                long time = calendar.getTimeInMillis();
                for (int i = 0; i < time; i++) {
                    long futureTime = System.currentTimeMillis() + time;
                    while (System.currentTimeMillis() < futureTime) {
                        synchronized (this) {
                            try {
                                wait(futureTime - System.currentTimeMillis());
                                NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                                nm.notify(uniqueID, AddReminderActivity.notification.build());
                            } catch (Exception e) {
                            }
                        }
                    }
                }
            }
        };
        Thread thread = new Thread(r);
        thread.start();
        return Service.START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
