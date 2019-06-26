package com.example.headsupnotification;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    int NOTIFICATION_ID_NORMAL_SIZE = 1;
    String CHANNEL_ID = "my_channel_01";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendChannel1(View view) {
        NotificationManager notificationManager= (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {

            CharSequence name = "my_channel";
            String Description = "This is my channel";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            mChannel.setDescription(Description);
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.RED);
            mChannel.enableVibration(true);
            mChannel.setVibrationPattern(new long[]{100, 200, 300});
            mChannel.setShowBadge(false);
            notificationManager.createNotificationChannel(mChannel);
        }
        String title = "Normal Size Happy Christmas. ";
        String textContent = "Christmas is comming --- dev2qa.com";
        int smallIconResId = R.drawable.ic_launcher_background;
        Notification builder=new NotificationCompat.Builder(this,CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(textContent)
                .setSmallIcon(smallIconResId)
                .setDefaults(Notification.DEFAULT_ALL)
                .setAutoCancel(false)
                .build();
        builder.flags=Notification.FLAG_ONGOING_EVENT|Notification.FLAG_INSISTENT;
        notificationManager.notify(NOTIFICATION_ID_NORMAL_SIZE,builder);

    }


}
