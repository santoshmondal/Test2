package com.example.santosh.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class Main215Activity extends AppCompatActivity {
    private RecyclerView rv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main215);

        rv1 = (RecyclerView) findViewById(R.id.rv1);

        Main215Adapter adapter = new Main215Adapter(Common.getSampleData(20));
        rv1.setAdapter(adapter);
        rv1.setLayoutManager(new LinearLayoutManager(this));
    }

}
