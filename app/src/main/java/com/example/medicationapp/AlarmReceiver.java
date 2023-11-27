package com.example.medicationapp;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationHelper.showNotification(context, "Medication Reminder", "It's time to take your medication.");
    }
}
