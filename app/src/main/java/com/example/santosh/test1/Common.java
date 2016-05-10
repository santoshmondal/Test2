package com.example.santosh.test1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import demo.test.SamplePojo;

/**
 * Created by santosh on 5/10/16.
 */
public class Common {
    public static String[] DAYS = new String[]{"Sunday", "Monday", "Tuesday", "Wednesday", "Thrusday", "Friday", "Saturday"};
    public static String[] PROG = new String[]{"Java", "Php", "J2EE", "Android", "IOS", "Angular", "NODE", "MEAN"};


    public static List<SamplePojo> getSampleData() {
        Random random = new Random();

        List<SamplePojo> datalist = new ArrayList<>();
        for(int i=0; i<10; i++) {
            SamplePojo data = new SamplePojo();

            int val = random.nextInt(7);

            data.setTitle(PROG[val] +  " Programming");
            data.setDescr("Application development using " + PROG[val]);

            datalist.add(data);
        }

        return datalist;
    }
}
