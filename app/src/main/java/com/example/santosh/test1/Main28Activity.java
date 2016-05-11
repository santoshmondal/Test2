package com.example.santosh.test1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import demo.test.SamplePojo;

public class Main28Activity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private Button button18;
    private Button button19;
    private GridView gridView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main28);

        init();

        BaseAdapter3 adapter = new BaseAdapter3(this, R.layout.layout3, Common.getSampleData());
        gridView3.setAdapter(adapter);
    }

    private void init() {
        button18 = (Button) findViewById(R.id.button18);
        button19 = (Button) findViewById(R.id.button19);
        button18.setOnClickListener(this);
        button19.setOnClickListener(this);

        gridView3 = (GridView) findViewById(R.id.gridView3);
        gridView3.setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        Toast.makeText(this, b.getText(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        TextView t7 = (TextView) view.findViewById(R.id.textView7);
        Toast.makeText(this, t7.getText(), Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(this, Main29Activity.class);
        intent.putExtra("title", t7.getText());
        startActivity(intent);
    }
}


class BaseAdapter3 extends BaseAdapter {
    Context context;
    int resource;
    List<SamplePojo> datalist;

    BaseAdapter3(Context context, int resource, List<SamplePojo> datalist){
        this.context = context;
        this.resource = resource;
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

            BaseAdapter3Holder holder = new BaseAdapter3Holder(convertView);
            convertView.setTag(holder);
        }

        BaseAdapter3Holder holder = (BaseAdapter3Holder) convertView.getTag();
        holder.title.setText(getItem(position).getTitle());

        return convertView;
    }


    class BaseAdapter3Holder {
        TextView title;

        BaseAdapter3Holder(View convView) {
            title = (TextView) convView.findViewById(R.id.textView7);
        }
    }
}