package com.example.santosh.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class Main23Activity extends AppCompatActivity implements AdapterView.OnItemClickListener, View.OnClickListener {
    private Button button2;
    private Button button3;
    private ListView listView2;
    private ListView listView3;
    private ListView listView4;
    private ListView listView5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main23);


        initalize();

        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        listView2.setOnItemClickListener(this);
        listView3.setOnItemClickListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Common.DAYS);
        listView2.setAdapter(adapter);
        listView3.setAdapter(adapter);

        listView4.setAdapter(adapter);
        listView5.setAdapter(adapter);


    }

    private void initalize() {
         button2 = (Button)findViewById(R.id.button2);
         button3 = (Button) findViewById(R.id.button3);

        listView2 = (ListView) findViewById(R.id.listView2);
        listView3 = (ListView) findViewById(R.id.listView3);
        listView4 = (ListView) findViewById(R.id.listView4);
        listView5 = (ListView) findViewById(R.id.listView5);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tv = (TextView) view;
        Toast.makeText(this, tv.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        Toast.makeText(this, b.getText(), Toast.LENGTH_SHORT).show();
    }
}
