package com.xgf.transaction.springjdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJDBCTest {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/xgf/transaction/springjdbc/applicationContext.xml");
        UserDaoTemplete userDao = (UserDaoTemplete)context.getBean("userDaoTemplete");
        userDao.save();
    }
}
