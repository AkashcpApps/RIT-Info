package com.rithassan.info;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MyFirebaseMessagingService extends FirebaseMessagingService {
    private static final int NOTIFICATION_ID = 1;
    private static final String NOTIFICATION_CHANNEL_ID="my_notification";
    @Override
    public void onMessageReceived(RemoteMessage message) {
        sendMyNotification(message.getNotification().getBody(),message.getNotification().getTitle());
    }


    private void sendMyNotification(String message,String title) {

        //
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("notification", "Notifications");
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

        Uri soundUri= RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationManager notificationManager = (NotificationManager)getApplicationContext(). getSystemService(NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(NOTIFICATION_CHANNEL_ID, "My Notifications", NotificationManager.IMPORTANCE_DEFAULT);
            // Configure the notification channel.
            notificationChannel.setDescription("Channel description");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{ 3000});
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), NOTIFICATION_CHANNEL_ID)

                .setVibrate(new long[]{0})
                .setSound(RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION))
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.rit_info_logo)
                .setContentTitle(title)
                .setPriority(Notification.PRIORITY_HIGH)
                .setPriority(Notification.PRIORITY_MAX)
                .setContentText(message);


        notificationManager.notify(NOTIFICATION_ID, builder.build());
        DateFormat df = new SimpleDateFormat("d MMM");
        String date = df.format(Calendar.getInstance().getTime());
        DateFormat df1 = new SimpleDateFormat("h:mm a");
        String time = df1.format(Calendar.getInstance().getTime());
        DatabaseReference d= FirebaseDatabase.getInstance().getReference("Notice/"+time);
        d.child("title").setValue(title);
        d.child("description").setValue(message);
        d.child("date").setValue(date);
        d.child("time").setValue(time);
        MediaPlayer mediaPlayer=MediaPlayer.create(getApplicationContext(),R.raw.record_on);
        mediaPlayer.start();


    }
}