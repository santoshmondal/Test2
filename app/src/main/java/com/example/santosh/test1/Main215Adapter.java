package com.example.santosh.test1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import demo.test.SamplePojo;

/**
 * Created by santosh on 5/14/16.
 */
public class Main215Adapter extends RecyclerView.Adapter<Main215Adapter.Main215AdapterHolder>{

    private List<SamplePojo> datalist;
    public Main215Adapter(List<SamplePojo> datalist) {
        this.datalist = datalist;
    }

    @Override
    public Main215Adapter.Main215AdapterHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.layout, parent, false);

        Main215AdapterHolder holder = new Main215AdapterHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(Main215Adapter.Main215AdapterHolder holder, int position) {
          holder.title.setText(datalist.get(position).getTitle());
          holder.descr.setText(datalist.get(position).getDescr());
    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public static class Main215AdapterHolder extends RecyclerView.ViewHolder{
        TextView title;
        TextView descr;

        public Main215AdapterHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.textView5);
            descr = (TextView) itemView.findViewById(R.id.textView6);
        }
    }
}
