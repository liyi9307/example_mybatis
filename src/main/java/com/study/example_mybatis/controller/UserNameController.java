package com.study.example_mybatis.controller;

import com.study.example_mybatis.entity.UserName;
import com.study.example_mybatis.mapper.UserNameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserNameController {
    @Autowired
    private UserNameMapper userNameMapper;

    @GetMapping("/username/{id}")
    public UserName selectUserName(@PathVariable("id")int id){
        return userNameMapper.selectUserName(id);
    }
    @GetMapping("/username")
    public UserName insertUserName(UserName userName){
        userNameMapper.insertUserName(userName);
        return userName;
    }
    @GetMapping("/delete/{id}")
    public String deleteUserName(@PathVariable("id")int id){
        userNameMapper.deleteUserName(id);
        return "delete successfully";
    }

    @GetMapping("/update")
    public UserName updateUserName(UserName userName){
        userNameMapper.updateUserName(userName);
        return userName;
    }

}
