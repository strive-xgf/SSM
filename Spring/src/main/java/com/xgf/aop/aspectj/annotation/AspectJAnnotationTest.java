package com.xgf.aop.aspectj.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AspectJAnnotationTest {
    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/xgf/aop/aspectj/annotation/applicationContext.xml");

        UserDao userDao = (UserDao) context.getBean("userDao");
        //调用方法
        userDao.save();
        userDao.delete();
    }
}
