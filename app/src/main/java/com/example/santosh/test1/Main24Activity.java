package com.example.santosh.test1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import demo.test.SamplePojo;


public class Main24Activity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private Button button6;
    private Button button7;
    private ListView listView6;
    private ListView listView7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main24);

        initialize();

        HelloAdapter adapter = new HelloAdapter(this, R.layout.layout, Common.getSampleData());
        listView6.setAdapter(adapter);
        listView7.setAdapter(adapter);
    }

    private void initialize() {
        button6 = (Button) findViewById(R.id.button6);
        button7 = (Button) findViewById(R.id.button7);

        button6.setOnClickListener(this);
        button7.setOnClickListener(this);

        listView6 = (ListView) findViewById(R.id.listView6);
        listView7 = (ListView) findViewById(R.id.listView7);

        listView6.setOnItemClickListener(this);
        listView7.setOnItemClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        Toast.makeText(this, b.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tv5 = (TextView) view.findViewById(R.id.textView5);
        Toast.makeText(this, tv5.getText(), Toast.LENGTH_SHORT).show();
    }
}


class HelloAdapter extends ArrayAdapter<SamplePojo>{
    private Context context;
    private int resource;
    private List<SamplePojo> datalist;

    public HelloAdapter(Context context, int resource, List<SamplePojo> datalist) {
        super(context, resource, datalist);
        this.context = context;
        this.resource = resource;
        this.datalist = datalist;
    }

    @Override
    public View getView(int position, View row, ViewGroup parent) {
        if(row == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(resource, parent, false);

            HelloHolder holder = new HelloHolder(row);
            row.setTag(holder);
        }

        HelloHolder holder = (HelloHolder) row.getTag();
        holder.title.setText(datalist.get(position).getTitle());
        holder.descr.setText(datalist.get(position).getTitle());

        return row;
    }

    class HelloHolder {
        TextView title;
        TextView descr;

        HelloHolder(View row){
            title = (TextView) row.findViewById(R.id.textView5);
            descr = (TextView) row.findViewById(R.id.textView6);
        }
    }
}
