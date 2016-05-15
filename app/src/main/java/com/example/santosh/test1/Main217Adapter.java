package com.example.santosh.test1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import demo.test.SamplePojo;

/**
 * Created by santosh on 5/15/16.
 */
public class Main217Adapter extends RecyclerView.Adapter<Main217Adapter.Main217Holder> {
    private List<SamplePojo> datalist;

    public Main217Adapter(List<SamplePojo> datalist) {
        this.datalist = datalist;
    }

    @Override
    public Main217Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflaterr = LayoutInflater.from(parent.getContext());
        View view = inflaterr.inflate(R.layout.layout, parent, false);

        Main217Holder holder = new Main217Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Main217Holder holder, int position) {
        holder.title.setText(datalist.get(position).getTitle());
        holder.descr.setText(datalist.get(position).getDescr());

    }

    @Override
    public int getItemCount() {
        return datalist.size();
    }

    public static class Main217Holder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView descr;

        public Main217Holder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.textView5);
            descr = (TextView) itemView.findViewById(R.id.textView6);
        }
    }
}
