package com.example.santosh.test1;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {
    private static final String TAG = MyReceiver.class.getName();

    public MyReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Receiver, Intent, Boot Completed", Toast.LENGTH_SHORT).show();
        Log.i(TAG, "On Receive");
    }
}
