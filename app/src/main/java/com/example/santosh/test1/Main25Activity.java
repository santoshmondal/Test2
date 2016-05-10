package com.example.santosh.test1;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import demo.test.SamplePojo;

public class Main25Activity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private Button button11;
    private Button button10;
    private ListView listView8;
    private ListView listView9;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main25);

        init();

        BaseAdapter1 adapter = new BaseAdapter1(this, R.layout.layout, Common.getSampleData());
        listView8.setAdapter(adapter);
        listView9.setAdapter(adapter);
    }

    private void init() {
        button11 = (Button) findViewById(R.id.button11);
        button10 = (Button) findViewById(R.id.button10);

        button11.setOnClickListener(this);
        button10.setOnClickListener(this);

        listView8 = (ListView) findViewById(R.id.listView8);
        listView9 = (ListView) findViewById(R.id.listView9);

        listView8.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        Toast.makeText(this, b.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}


class BaseAdapter1 extends BaseAdapter {
    Context context;
    int resource;
    List<SamplePojo> datalist;

    BaseAdapter1(Context context, int resource, List<SamplePojo> datalist ) {
        this.context = context;
        this.resource = resource;
        this.datalist = datalist;
    }

    @Override
    public int getCount() {
        return datalist.size();
    }

    @Override
    public Object getItem(int position) {
        return datalist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource, parent, false);

            Holder1 holder = new Holder1(convertView);
            convertView.setTag(holder);
        }

        Holder1 holder = (Holder1) convertView.getTag();
        holder.title.setText(datalist.get(position).getTitle());
        holder.descr.setText(datalist.get(position).getDescr());

        return convertView;
    }
}

class Holder1 {
    TextView title;
    TextView descr;

    Holder1(View row) {
        title = (TextView) row.findViewById(R.id.textView5);
        descr = (TextView) row.findViewById(R.id.textView6);
    }
}