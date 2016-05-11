package com.example.santosh.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main29Activity extends AppCompatActivity {
    private TextView textView8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main29);

        textView8  = (TextView) findViewById(R.id.textView8);

        String title = getIntent().getStringExtra("title");
        textView8.setText(title);

    }
}
