package com.study.example_mybatis.mapper;

import com.study.example_mybatis.entity.User;
import org.apache.ibatis.annotations.*;

/*
* 注解版mybatis
* 加Mapper注解，或者在启动appplication类名上加MapperScan，指定value
* */

@Mapper
public interface UserMapper {
    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert into user(name, age) values (#{name}, #{age})")
    public int insertUser(User user);

    @Delete("delete from user where id = #{id}")
    public int deleteUser(int id);

    @Select("select * from user where id = #{id}")
    public User queryUser(int id);

    @Update("update user set name = #{name}, age = #{age} where id = #{id} ")
    public int updateUser(User user);
}
