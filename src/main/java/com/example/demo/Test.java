package com.example.demo;

import com.example.model.Times;
import com.example.model.TimesMapper;
import com.example.model.User;
import com.example.model.UserMapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by Kang.Zheng on 2017/11/28.
 */
@Controller

public class Test {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private TimesMapper timesMapper;

    //@Results({@Result()}
    //)
    @RequestMapping("/testtime")

    public String testt() {

        return "register";


    }

    @RequestMapping("/testlogin")

    public String test() {

        return "index";


    }
}