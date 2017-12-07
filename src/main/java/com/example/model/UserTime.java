package com.example.model;

import java.util.Date;

/**
 * Created by Kang.Zheng on 2017/11/29.
 */
public class UserTime {

    private int id;
    private String phone;
    private Date codeTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCodeTime() {
        return codeTime;
    }

    public void setCodeTime(Date codeTime) {
        this.codeTime = codeTime;
    }
}
