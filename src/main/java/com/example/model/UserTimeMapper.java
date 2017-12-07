package com.example.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * Created by Kang.Zheng on 2017/11/29.
 */
@Mapper
public interface UserTimeMapper {

    @Insert("insert into userTime(phone,codeTime) values(#{phone},#{codeTime})")
    void insert(UserTime userTime);
    @Update("update userTime set codeTime=#{codeTime} where phone=#{phone}")
    void update(UserTime userTime);
    @Select("select * from userTime where phone=#{phone}")
    UserTime getTime(UserTime userTime);
}
