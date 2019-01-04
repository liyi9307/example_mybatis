package com.study.example_mybatis.controller;

import com.study.example_mybatis.entity.User;
import com.study.example_mybatis.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserMapper userMapper;



    @GetMapping("/user/{id}")
    public User queryById(@PathVariable("id")int id){
        System.out.println(id);
        return userMapper.queryUser(id);
    }
    @GetMapping("/user")
    public User insertUser(User user){

        userMapper.insertUser(user);
        return user;
    }
    @GetMapping("/userUpdate")
    public User updateUser(User user){
        userMapper.updateUser(user);
        return user;
    }
    @GetMapping("/userDelete/{id}")
    public String deleteUser(@PathVariable("id")int id){
        userMapper.deleteUser(id);
        return "delete successfully";
    }




}

