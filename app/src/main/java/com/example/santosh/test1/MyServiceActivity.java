package com.example.santosh.test1;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private String TAG = "MY_SERVICE_ACTIVITY";
    private MyService boundService;
    private boolean bouneded;

    private Button button30;
    private Button button31;

    private Button button32;
    private Button button33;

    private Button button34;
    private Button button35;

    private ServiceConnection serviceConn = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            boundService = ((MyService.LocalBinder) service).getService();
            bouneded = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            bouneded = false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service);

        init();

        button30.setOnClickListener(this);
        button31.setOnClickListener(this);

        button32.setOnClickListener(this);
        button33.setOnClickListener(this);

        button34.setOnClickListener(this);
        button35.setOnClickListener(this);
    }

    @Override
    protected void onStop() {
        super.onStop();

        if(bouneded){
            boundService.unbindService(serviceConn);
        }
    }

    private void init() {
        button30 = (Button) findViewById(R.id.button30);
        button31 = (Button) findViewById(R.id.button31);

        button32 = (Button) findViewById(R.id.button32);
        button33 = (Button) findViewById(R.id.button33);

        button34 = (Button) findViewById(R.id.button34);
        button35 = (Button) findViewById(R.id.button35);
    }


    @Override
    public void onClick(View v) {
        Log.i(TAG, "Button Clicked");

        if(v.getId() == R.id.button30) {

            Toast.makeText(this, "Mohan", Toast.LENGTH_SHORT).show();
        } else if(v.getId() == R.id.button31) {

            Toast.makeText(this, "Jodaro", Toast.LENGTH_SHORT).show();
        } else if(v.getId() == R.id.button32) {

            Log.i(TAG, "Start Service");
            Toast.makeText(this, "Start Service", Toast.LENGTH_SHORT).show();

            Intent serviceIntent = new Intent(this, MyService.class);
            startService(serviceIntent);
        } else if(v.getId() == R.id.button33) {

            Log.i(TAG, "Stop Service");
            Toast.makeText(this, "Stop Service", Toast.LENGTH_SHORT).show();

            Intent serviceIntent = new Intent(this, MyService.class);
            stopService(serviceIntent);
        } else if(v.getId() == R.id.button34) {

            Log.i(TAG, "Bounded Service Start");
            Toast.makeText(this, "Bound Service Start", Toast.LENGTH_SHORT).show();

            Intent serviceIntent = new Intent(this, MyService.class);
            bindService(serviceIntent, serviceConn, BIND_AUTO_CREATE);
        } else if(v.getId() == R.id.button35) {

            Log.i(TAG, "Unbound Service");
            Toast.makeText(this, "Unbound Service", Toast.LENGTH_SHORT).show();

            unbindService(serviceConn);
        }
    }
}
