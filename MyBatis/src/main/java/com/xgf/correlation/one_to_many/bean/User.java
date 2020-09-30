package com.xgf.correlation.one_to_many.bean;

import org.springframework.context.annotation.Lazy;

import java.util.List;


//  一个user有多个Task
public class User {

    private Integer id;
    private String username;
    private String password;

//  一的一方保留多的一方信息
    private List<Task> taskList;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", taskList=" + taskList +
                '}';
    }
}
