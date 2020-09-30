package com.xgf.ioc.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class User {
    private String name;

    public User() {
        System.out.println("调用User的无参构造器");
    }

    public User(String name) {
        System.out.println("调用User的name参数构造器");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}
