package com.example.santosh.test1;

import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import demo.test.SamplePojo;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Main218Activity extends AppCompatActivity implements View.OnClickListener {
    public static String BASE_URL = "http://192.168.0.106:3000";

    private TextView textView11;
    private Button button26;
    private  Button button27;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main218);

        init();
    }

    private void init() {
        textView11 = (TextView) findViewById(R.id.textView11);

        button26 = (Button) findViewById(R.id.button26);
        button27 = (Button) findViewById(R.id.button27);

        button26.setOnClickListener(this);
        button27.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId() == button26.getId()) {
            Retrofit retrofit = new Retrofit.Builder()
                                .baseUrl(BASE_URL)
                                .addConverterFactory(ScalarsConverterFactory.create())
                                .build();

            Main218Api api = retrofit.create(Main218Api.class);
            api.hello1().enqueue(new Callback<String>() {
                @Override
                public void onResponse(Call<String> call, Response<String> response) {
                    textView11.setText(response.body());
                }

                @Override
                public void onFailure(Call<String> call, Throwable t) {

                }
            });

        } else if(v.getId() == button27.getId()){
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .build();

            Main218Api api = retrofit.create(Main218Api.class);
            api.hello().enqueue(new Callback<SamplePojo>() {
                @Override
                public void onResponse(Call<SamplePojo> call, Response<SamplePojo> response) {
                    textView11.setText(response.body().getTitle());
                }

                @Override
                public void onFailure(Call<SamplePojo> call, Throwable t) {

                }
            });
        }
    }
}
