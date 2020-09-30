package com.xgf.aop.aspectj.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
* 基于XML配置开发AspectJ是指
    通过XML配置文件定义切面、切入点及通知，所有这些定义都必须在<aop:config>元素内
* */
public class AspectJXMLTest {
    public static void main(String[] args) {
        //切面 ：通知 + 切点
//        通知：增强 记录日志 权限验证  事务处理
//        切点：地点  +  时间
//              地点：通知应用的地方  具体方法：那个包 那个类 哪些方法 com.qst.spring.dao.save*(String str)【save开头 的只能有一个参数String】
//              时间：方法执行前，执行后，抛出异常 方法执行前和执行后
        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/xgf/aop/aspectj/xml/applicationContext.xml");

        /*代理类 save 增强 before加到save方法之前*/
        UserDao userDao = (UserDao) context.getBean("userDao");
        userDao.save();
        userDao.delete();
    }
}
