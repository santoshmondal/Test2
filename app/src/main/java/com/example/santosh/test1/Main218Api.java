package com.example.santosh.test1;

import demo.test.SamplePojo;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by santosh on 5/15/16.
 */
public interface Main218Api {

    @GET("/pub/hello")
    public Call<SamplePojo> hello();

    @GET("/pub/hello1")
    public Call<String> hello1();

}
