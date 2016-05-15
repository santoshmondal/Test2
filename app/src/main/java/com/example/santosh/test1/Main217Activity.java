package com.example.santosh.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class Main217Activity extends AppCompatActivity {
    private RecyclerView rv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main217);


        rv2 = (RecyclerView) findViewById(R.id.rv2);

        Main217Adapter adapter = new Main217Adapter(Common.getSampleData(5));
        rv2.setAdapter(adapter);
        rv2.setLayoutManager(new LinearLayoutManager(this));
    }
}
