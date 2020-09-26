package com.xgf.correlation.one_to_one;


import com.xgf.correlation.one_to_one.bean.Person;
import com.xgf.correlation.one_to_one.dao.PersonMapper;
import com.xgf.mybatis_spring.bean.Student;
import com.xgf.mybatis_spring.dao.StudentMapper;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

//测试类 测试spring-mybatis整合 进行增删查改
public class TestOneToOne {

    private static ApplicationContext applicationContext = null;
    private static PersonMapper personMapper = null;

    //静态代码块 只加载一次
    static {
        //加载配置文件                                                          com/xgf/correlation/one_to_one/config/applicationContext.xml
        applicationContext = new ClassPathXmlApplicationContext("com/xgf/correlation/one_to_one/config/applicationContext.xml");
        //获取bean的两种方式
        // 1.类名首字母小写
//        studentMapper = (StudentMapper) applicationContext.getBean("personMapper");
        // 2.类.class
        personMapper = (PersonMapper) applicationContext.getBean(PersonMapper.class);
    }

    //第一种(getPersonById)直接通过id一条SQL语句查询     测试getPersonById()方法 通过id查询person和card表
    @Test
    public void test01(){
        System.out.println("===查找id为1的Person：===");
        Person person = personMapper.getPersonById(1);
        System.out.println(person);
    }

    //第二种(getPersonById2)通过嵌套查询实现     测试getPersonById()方法 通过id查询person和card表
    @Test
    public void test02(){
        System.out.println("===查找id为2的Person：===");
        Person person = personMapper.getPersonById2(2);
        System.out.println(person);
    }

    //(getPersonByName)通过用户名查询
    @Test
    public void test03(){
        System.out.println("===查找id为2的Person：===");
        Person person = personMapper.getPersonByName("person2222");
        System.out.println(person);
    }
}
