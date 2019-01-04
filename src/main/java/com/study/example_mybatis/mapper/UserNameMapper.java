package com.study.example_mybatis.mapper;

import com.study.example_mybatis.entity.UserName;
import org.apache.ibatis.annotations.Mapper;

/*
 * mapper文件配置
 * 1. 需要全局映射文件和单个接口映射文件
 * 2. 需要在配置文件中加入映射文件地址
 */
@Mapper
public interface UserNameMapper {
    public void insertUserName(UserName userName);
    public void deleteUserName(int id);
    public UserName selectUserName(int id);
    public void updateUserName(UserName userName);

}
