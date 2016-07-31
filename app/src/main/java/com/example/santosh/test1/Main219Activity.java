package com.example.santosh.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main219Activity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView12;
    private Button button28;
    private Button button29;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main219);

        textView12 = (TextView) findViewById(R.id.textView12);
        button28 = (Button) findViewById(R.id.button28);
        button29 = (Button) findViewById(R.id.button29);

        button28.setOnClickListener(this);
        button29.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                textView12.setTextAppearance(Main219Activity.this, R.style.s1);
            }
        });
    }

    @Override
    public void onClick(View v) {
        textView12.setTextAppearance(this, R.style.s1_s2);
    }
}
