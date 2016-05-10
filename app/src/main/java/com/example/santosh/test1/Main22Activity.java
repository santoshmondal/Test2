package com.example.santosh.test1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.List;

public class Main22Activity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private Button button9;
    private ListView listView;

    private String[] days = new String[]{"Sundya", "Monday", "Tuesday"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main22);
        initalize();

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, days);
        listView.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {
        Toast.makeText(this, "Hello World", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        try{
            String json = "{\"id\":1}";
            JSONObject obj = new JSONObject(json);

            TextView text = (TextView) view;
            Toast.makeText(this, text.getText() + " " + obj.get("id"), Toast.LENGTH_SHORT).show();
        } catch(Exception e) {
            Log.e("ERROR", "An Exception!!");
        }
    }

    private void initalize() {
        button9 = (Button)findViewById(R.id.button9);
        listView = (ListView)findViewById(R.id.listView);

        button9.setOnClickListener(this);
        listView.setOnItemClickListener(this);
    }

}
