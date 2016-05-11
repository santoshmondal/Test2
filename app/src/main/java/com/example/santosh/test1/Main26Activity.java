package com.example.santosh.test1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import demo.test.SamplePojo;

public class Main26Activity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private Button button12;
    private Button button13;
    private ListView listView10;
    private ListView listView11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main26);

        init();

        ArrayAdapter2 adapter = new ArrayAdapter2(this, R.layout.layout, Common.getSampleData());
        listView10.setAdapter(adapter);
        listView11.setAdapter(adapter);
    }

    private void init() {
        button12 = (Button) findViewById(R.id.button12);
        button13 = (Button) findViewById(R.id.button13);

        button12.setOnClickListener(this);
        button13.setOnClickListener(this);

        listView10 = (ListView) findViewById(R.id.listView10);
        listView11 = (ListView) findViewById(R.id.listView11);

        listView10.setOnItemClickListener(this);
        listView11.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        Toast.makeText(this, b.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView tv = (TextView) view.findViewById(R.id.textView5);
        Toast.makeText(this, tv.getText(), Toast.LENGTH_SHORT).show();
    }
}


class ArrayAdapter2 extends ArrayAdapter<SamplePojo>{
    Context context;
    int resource;
    List<SamplePojo> datalist;

    public ArrayAdapter2(Context context, int resource, List<SamplePojo> datalist) {
        super(context, resource, datalist);

        this.context = context;
        this.resource = resource;
        this.datalist = datalist;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource, parent, false);

            ArrayAdapter2Holder holder = new ArrayAdapter2Holder(convertView);
            convertView.setTag(holder);
        }

        ArrayAdapter2Holder holder = (ArrayAdapter2Holder) convertView.getTag();

        holder.detail.setText(datalist.get(position).getTitle());
        holder.descr.setText(datalist.get(position).getDescr());

        return convertView;
    }


    class ArrayAdapter2Holder {
        TextView detail;
        TextView descr;

        ArrayAdapter2Holder(View row) {
            detail = (TextView) row.findViewById(R.id.textView5);
            descr = (TextView) row.findViewById(R.id.textView6);
        }
    }
}