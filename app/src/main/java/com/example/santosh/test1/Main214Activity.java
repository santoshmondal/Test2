package com.example.santosh.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class Main214Activity extends AppCompatActivity implements View.OnClickListener {
    ImageView imageView3;
    ImageView imageView4;
    ImageView imageView5;

    ImageView imageView6;
    ImageView imageView7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main214);

        init();
    }

    private void init() {
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);

        imageView6 = (ImageView) findViewById(R.id.imageView6);
        imageView7 = (ImageView) findViewById(R.id.imageView7);

        imageView3.setOnClickListener(this);
        imageView4.setOnClickListener(this);
        imageView5.setOnClickListener(this);

        imageView6.setOnClickListener(this);
        imageView7.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        ImageView iv = (ImageView) v;

        if(iv.getId() == imageView3.getId() ) {
            imageView3.setVisibility(View.GONE);
            imageView5.setVisibility(View.VISIBLE);
        } else if(iv.getId() == imageView5.getId()) {
            imageView5.setVisibility(View.GONE);
            imageView3.setVisibility(View.VISIBLE);
        }


        if(iv.getId() == imageView6.getId()) {
            imageView6.setVisibility(View.GONE);
            imageView7.setVisibility(View.VISIBLE);
        } else if(iv.getId() == imageView7.getId()) {
            imageView7.setVisibility(View.GONE);
            imageView6.setVisibility(View.VISIBLE);
        }

    }
}
