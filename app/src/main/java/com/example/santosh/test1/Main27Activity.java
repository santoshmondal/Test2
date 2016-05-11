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

import java.util.List;

import demo.test.SamplePojo;

public class Main27Activity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private Button button14;
    private Button button15;
    private ListView listView12;
    private ListView listView13;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main27);

        init();

        BaseAdapter2 adapter = new BaseAdapter2(this, R.layout.layout, Common.getSampleData());
        listView12.setAdapter(adapter);
        listView13.setAdapter(adapter);
    }

    private void init() {
        button14 = (Button) findViewById(R.id.button14);
        button15 = (Button) findViewById(R.id.button15);

        button14.setOnClickListener(this);
        button15.setOnClickListener(this);


        listView12 = (ListView) findViewById(R.id.listView12);
        listView13 = (ListView) findViewById(R.id.listView13);

        listView12.setOnItemClickListener(this);
        listView13.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}


class BaseAdapter2 extends BaseAdapter {
    Context context;
    int resource;
    List<SamplePojo> datalist;

    BaseAdapter2(Context context, int resource, List<SamplePojo> datalist) {
        this.context = context;
        this.resource =resource;
        this.datalist = datalist;
    }

    @Override
    public int getCount() {
        return datalist.size();
    }

    @Override
    public SamplePojo getItem(int position) {
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

            BaseAdapter2Holder holder = new BaseAdapter2Holder(convertView);
            convertView.setTag(holder);
        }

        BaseAdapter2Holder holder = (BaseAdapter2Holder) convertView.getTag();
        holder.title.setText(getItem(position).getTitle());
        holder.descr.setText(getItem(position).getDescr());


        return convertView;
    }

    class BaseAdapter2Holder {
        TextView title;
        TextView descr;

        BaseAdapter2Holder(View view){
            title = (TextView) view.findViewById(R.id.textView5);
            descr = (TextView) view.findViewById(R.id.textView6);
        }
    }
}