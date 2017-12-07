package com.example.model;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Created by Kang.Zheng on 2017/11/28.
 */
@Mapper
public interface TimesMapper {

   @Insert("insert times(times) values(#{times})")
    public  void insert(Times times);
 }
