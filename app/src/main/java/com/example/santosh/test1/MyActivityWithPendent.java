package com.example.santosh.test1;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MyActivityWithPendent extends AppCompatActivity implements View.OnClickListener {

    private Button button36;
    private Button button37;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_activity_with_pendent);

        init();

        button36.setOnClickListener(this);
        button37.setOnClickListener(this);
    }

    private void init() {
        button36 = (Button) findViewById(R.id.button36);
        button37 = (Button) findViewById(R.id.button37);
    }


    @Override
    public void onClick(View v) {

        if(v.getId() == R.id.button36) {
            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            Intent intent = new Intent(this, MyServiceActivity.class);
            PendingIntent pintent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

            Notification.Builder builder = new Notification.Builder(getApplicationContext());
            builder.setAutoCancel(false);
            builder.setTicker("this is ticker text");
            builder.setContentTitle("WhatsApp Notification");
            builder.setContentText("You have a new message");
            builder.setSmallIcon(R.mipmap.ic_launcher);
            builder.setContentIntent(pintent);
            builder.setOngoing(true);
            builder.setNumber(100);

            Notification notify = builder.build();
            nm.notify(0, notify);

            Toast.makeText(this, "Notification 1", Toast.LENGTH_SHORT).show();
        } else if(v.getId() == R.id.button37) {
            NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

            Intent intent = new Intent(this, Main219Activity.class);
            PendingIntent pintent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 0);

            Notification.Builder builder = new Notification.Builder(getApplicationContext());
            builder.setAutoCancel(true);
            builder.setTicker("this is ticker text 2");
            builder.setContentTitle("WhatsApp Notification 2");
            builder.setContentText("You have a new message 2 ");
            builder.setSmallIcon(R.mipmap.ic_launcher);
            builder.setContentIntent(pintent);
            builder.setOngoing(true);
            builder.setNumber(100);

            Notification notify = builder.build();
            nm.notify(1, notify);

            Toast.makeText(this, "Notification 2", Toast.LENGTH_SHORT).show();
        }
    }
}
