package com.xgf.mysql_cache.bean;

import java.io.Serializable;

//实现序列化，因为cache缓存的readonly设置为false，所以需要实现序列化
public class Customer  implements Serializable {

    private Integer id;         //id主键自动增长
    private String username;    //用户名
    private String job;         //工作

    public Customer() {
    }

    public Customer(String username, String job) {
        this.username = username;
        this.job = job;
    }

    public Customer(Integer id, String username, String job) {
        this(username, job);
        this.id = id;
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

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
