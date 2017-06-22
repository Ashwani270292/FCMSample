package com.mutationapps.ansh.fcmsample.services;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.util.Log;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.mutationapps.ansh.fcmsample.MainActivity;
import com.mutationapps.ansh.fcmsample.R;

/**
 * Created by hp on 6/22/2017.
 */

public class MyFirebaseMessagingService extends FirebaseMessagingService {

    private static final String TAG = "Debugging";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        Log.d(TAG,"From: "+remoteMessage.getFrom());
        Log.d(TAG,"Message Body: "+ remoteMessage.getNotification().getBody());

        notifyDevice(remoteMessage.getNotification().getBody());
    }

    private void notifyDevice(String message){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("Message","Google push says: "+message);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);

        //for making a sound when notification shows up
        Uri defaultSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        //Building the notification
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .setContentTitle("You have a new message")
                .setContentText(message)
                .setAutoCancel(true)
                .setSound(defaultSound)
                .setContentIntent(pendingIntent);
        //raising the notification
        NotificationManager notificationManager = (NotificationManager)getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(0,notificationBuilder.build());
    }
}
