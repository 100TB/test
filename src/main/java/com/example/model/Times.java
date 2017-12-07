package com.example.model;


import java.util.Date;

/**
 * Created by Kang.Zheng on 2017/11/28.
 */
public class Times {
    public Date getTimes() {
        return times;
    }

    public void setTimes(Date times) {
        this.times = times;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private Date times;
    private int id;


}
