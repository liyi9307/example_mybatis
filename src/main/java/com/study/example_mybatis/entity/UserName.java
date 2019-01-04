package com.study.example_mybatis.entity;

public class UserName {
    private int id;
    private String name;
    private String password;

    public UserName() {
    }

    public UserName(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public UserName(int id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
