package com.example.a8notification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.res.ResourcesCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;


public class MainActivity extends AppCompatActivity {
 private  static final String CHANnel_id="my channel";
    private  static final int notifid=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotificationManager nm=(NotificationManager)getSystemService(NOTIFICATION_SERVICE);
//         image ko liya drawable me
        Drawable drawable= ResourcesCompat.getDrawable(getResources(),R.drawable.nortri,null);
        // convert bitmap
        BitmapDrawable bitmapDrawable=(BitmapDrawable) drawable;
//        get bit map
        Bitmap largeIcon=bitmapDrawable.getBitmap();


        Notification notification;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
           notification=new Notification.Builder(this,CHANnel_id)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.nortri).
                    setContentText("new message")
                    .setSubText("hello this is new message given")
                    .setChannelId(CHANnel_id)
                    .build();
            nm.createNotificationChannel(new NotificationChannel(CHANnel_id,"new channer",NotificationManager.IMPORTANCE_HIGH));
        }else{
          notification=new Notification.Builder(this)
                    .setLargeIcon(largeIcon)
                    .setSmallIcon(R.drawable.nortri).
                    setContentText("new message")
                    .setSubText("hello this is new message given")
                    .build();
        }
         nm.notify(notifid,notification);
    }
}