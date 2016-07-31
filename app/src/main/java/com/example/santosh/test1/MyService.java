package com.example.santosh.test1;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class MyService extends Service {
    private static final String TAG = MyService.class.getName();
    private final IBinder mBinder = new LocalBinder();


    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();

        Log.i(TAG, "On Create");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "On Start Command");

        Toast.makeText(this, "At Service, and it started", Toast.LENGTH_SHORT).show();
        return START_STICKY;
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i(TAG, "On BIND");

        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(TAG, "On UN_BIND");

        return super.onUnbind(intent);
    }


    @Override
    public void onRebind(Intent intent) {
        super.onRebind(intent);

        Log.i(TAG, "On RE_BIND");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Toast.makeText(this, "At Service, and it stopped.", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "On DESTROY");
    }


    public class LocalBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }
}
