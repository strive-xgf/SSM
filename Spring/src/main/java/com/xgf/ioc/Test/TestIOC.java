package com.xgf.ioc.Test;


import com.xgf.ioc.controller.UserController;
import com.xgf.ioc.bean.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

/*
* 测试IOC依赖注入 - 通过setter方法注入
* */
public class TestIOC {
    public static void main(String[] args) {
        //注解进行配置,实例化ApplicationContext容器
        ApplicationContext context = new ClassPathXmlApplicationContext("com/xgf/ioc/applicationContext.xml");

        //通过getBean方法从ApplicationContext容器当中获取User对象
        UserController userContrller = (UserController)context.getBean("userController");

        //调用User的name参数构造器测试
        userContrller.saveUser(new User("GF_浪夏一学"));

    }
}
