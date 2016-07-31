package com.example.santosh.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MyServiceActivity extends AppCompatActivity implements View.OnClickListener {
    private String TAG = "MY_SERVICE_ACTIVITY";

    private Button button30;
    private Button button31;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_service);

        init();

        button30.setOnClickListener(this);
        button31.setOnClickListener(this);
    }

    private void init() {
        button30 = (Button) findViewById(R.id.button30);
        button31 = (Button) findViewById(R.id.button31);
    }


    @Override
    public void onClick(View v) {
        Log.i(TAG, "Button Clicked");

        if(v.getId() == R.id.button30) {

            Toast.makeText(this, "Button 30", Toast.LENGTH_LONG).show();
        } else if(v.getId() == R.id.button31) {

            Toast.makeText(this, "Button 31", Toast.LENGTH_LONG).show();
        }
    }
}
