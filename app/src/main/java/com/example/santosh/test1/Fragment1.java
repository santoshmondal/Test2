package com.example.santosh.test1;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by santosh on 5/12/16.
 */
public class Fragment1 extends Fragment implements View.OnClickListener {
    private View view;

    private Button button21;
    private Button button22;

    private  Communicator communicator;

    public void setCommunicator(Communicator communicator) {
        this.communicator = communicator;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d("Fragment", "On Attach");
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Fragment", "On Create");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d("Fragment", "On CreateView");
        View view = inflater.inflate(R.layout.fragment1, container, false);
        this.view = view;

        init();

        return view;
    }



    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.d("Fragment", "Activity created");
    }


    private void init() {
        button21 = (Button) view.findViewById(R.id.button21);
        button22 = (Button) view.findViewById(R.id.button22);

        button21.setOnClickListener(this);
        button22.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Button b = (Button) v;
        communicator.itc("Hello World");

        Toast.makeText(getActivity(), b.getText(), Toast.LENGTH_SHORT).show();
    }

    interface Communicator {
        public void itc(String data);
    }
}
