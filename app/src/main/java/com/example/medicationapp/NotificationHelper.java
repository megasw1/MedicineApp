package com.example.medicationapp;

import android.app.NotificationManager;
import android.content.Context;
import android.app.NotificationChannel;
import android.app.Notification;
import android.os.Build;
import androidx.core.app.NotificationCompat;

public class NotificationHelper {

    public static void showNotification(Context context, String title, String message) {
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        String CHANNEL_ID = "MedicationReminderChannel";
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "Medication Reminder";
            String Description = "Channel for Medication Reminder";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(Description);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(android.R.drawable.ic_dialog_info)

                .setAutoCancel(true);

        notificationManager.notify(1, builder.build());
    }
}
