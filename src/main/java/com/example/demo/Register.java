package com.example.demo;

import com.example.com.example.utils.Md5;
import com.example.model.User;
import com.example.model.UserMapper;
import com.example.model.UserTime;
import com.example.model.UserTimeMapper;
import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Kang.Zheng on 2017/11/27.
 */
@Controller
@RequestMapping("/register")
public class Register {
    @Autowired
    private UserTimeMapper userTimeMapper;
    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.username}")
    private String sender;

    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/hello")
public  String hello(){

        return  "register";
}

@RequestMapping("/sendNumber")
@ResponseBody
public Map sendNumber(HttpSession httpSession,UserTime userTime){
    Map map=new HashMap<String,String>();
    System.out.println(userTime.getPhone());
    UserTime userTime1=userTimeMapper.getTime(userTime);
    if(userTime1!=null) {
        if (new Date().getTime() - userTime1.getCodeTime().getTime() < 60000) {
            map.put("number", 3);
            return map;
        }
    }else{
        userTime.setCodeTime(new Date());
        userTimeMapper.insert(userTime);
    }
    map.put("number",null);
    Random random = new Random();
    String fourRandom = random.nextInt(10000) + "";
    int randLength = fourRandom.length();
    if(randLength<4){
        for(int i=1; i<=4-randLength; i++)
            fourRandom = "0" + fourRandom  ;
    }
   userTime.setCodeTime(new Date());
    userTimeMapper.update(userTime);
    System.out.println(userTime.getPhone());
    System.out.println(fourRandom);
    httpSession.setAttribute("number",fourRandom);
    System.out.println(httpSession.getAttribute("number"));

    map.put("number",1);
 return map;

}

@RequestMapping("/checkNm")
@ResponseBody
public Map checkNM(String number,HttpSession session,UserTime user){
    Map map=new HashMap<String,String>();
    map.put("numbercode",null);
  UserTime userTime= userTimeMapper.getTime(user);
    if(userTime!=null){
    if(new Date().getTime()-userTime.getCodeTime().getTime()>60000){
        map.put("numbercode",3);
        return map;
    }}
    System.out.println(number+"验证码"+session.getAttribute("number"));
    if(number.equals(session.getAttribute("number"))) {

        map.put("numbercode", 1);
    }
    return map;


}

@RequestMapping("/register")
@ResponseBody
public Map ajax(User user){
    Map map=new HashMap<String,String>();
    map.put("status",null);
    if(userMapper.findUsreByName(user)!=null){
        map.put("status","3");
        return map;
    }
    String password= Md5.MD5(user.getPassword());
    Date date=new Date();
    user.setPassword(password);
    user.setLoginTime(date);
    userMapper.insert(user);
    map.put("status",1);
    return  map;
}

    @RequestMapping("/ajax")
    @ResponseBody
    public Map login(User user){
        Map map=new HashMap<String,String>();
    map.put("code",null);
    if(userMapper.findUsreByName(user)!=null){
    map.put("code",1);
}
return map;
}


}
