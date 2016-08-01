package com.example.santosh.test1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyBroadcastReceiverActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = MyBroadcastReceiverActivity.class.getName();

    private Button button40;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_broadcast_receiver);

        init();

        button40.setOnClickListener(this);
    }

    private void init() {
        button40 = (Button) findViewById(R.id.button40);
    }

    @Override
    public void onClick(View v) {
        Log.i(TAG, "Custom Intent Broadcast.");

        Intent cIntent = new Intent();
        cIntent.setAction("com.example.CUSTOM");
        sendBroadcast(cIntent);

        Toast.makeText(this, "Custom Intent Broadcast", Toast.LENGTH_SHORT).show();
    }
}
