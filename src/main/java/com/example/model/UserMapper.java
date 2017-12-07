package com.example.model;


import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.springframework.stereotype.Component;

/**
 * Created by Kang.Zheng on 2017/11/27.
 */

@Mapper
@Component
public interface UserMapper {

    @Select("select * from user where phone=#{phone}")
    User findUsreByName(User user);
    @Insert("insert into user(phone,password,loginTime) values(#{phone},#{password},#{loginTime})")
    public  void  insert(User user);
    @Update("update user set worryLogin=#{worryLogin},loginTime=#{loginTime} where id=#{id}")
    void updateUser(User user);
    @Update("update user set worryLogin=0")
    void updateLogin();
    @Select("select * from user where phone=#{phone}")
    User getTime(User user);
    @Update("update user set codeTime=#{codeTime} where phone=#{phone}")
    void updateTime(User user);

}
