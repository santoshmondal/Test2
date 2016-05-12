package com.example.santosh.test1;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Main213Activity extends AppCompatActivity implements Fragment1.Communicator{
    FragmentManager fragmentManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main213);

        Fragment1.Communicator communicator = this;

        Fragment1 fragment1 = new Fragment1();
        Fragment2 fragment2 = new Fragment2();

        fragment1.setCommunicator(communicator);

        fragmentManager = getFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.add(R.id.l1, fragment1, "F1");
        transaction.add(R.id.l2, fragment2, "F2");

        transaction.commit();

    }

    @Override
    public void itc(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();

        Fragment2 fr2 = (Fragment2) fragmentManager.findFragmentByTag("F2");
        fr2.changeText(data);
    }
}
