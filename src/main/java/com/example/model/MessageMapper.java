package com.example.model;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * Created by Kang.Zheng on 2017/11/27.
 */

@Mapper
public interface MessageMapper {

    @Select("select * from message where id=#{id}")
    Message getUserById(Message message);
    @Select("select * from message")
    List<Message> getList();
    @Update("update message set title=#{title},information=#{information},createDate=#{createDate} where id=#{id}")
    void edit(Message message);
    @Delete("delete from message where id=#{id}")
    void delete(int id);

}
