/**
 * Created by Ebrar on 21/12/15.
 */

package com.beter.timehole.broadcastreceivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;


public class NotificationServiceStarterReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationEventReceiver.setupAlarm(context, NotificationEventReceiver.date);
    }
}
