package com.xgf.mysql_cache;


import com.xgf.mysql_cache.bean.Customer;
import com.xgf.mysql_cache.dao.CustomerMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

//测试缓存
public class TestCache {

    private static ApplicationContext applicationContext = null;
    private static CustomerMapper customerMapper = null;
    //查询对象
    //通过getCustomerByNameAndJobForWhere查询相当于
    private static Customer customer = new Customer("赵","开发人员");//初始化customer数据
    //查询结果
    private List<Customer> customerList = null;

    //只加载一次  @BeforeClass@BeforeClass只在类中执行一次, 必须声明为public static
    @BeforeClass
    public static void init(){
        //加载配置文件
        applicationContext = new ClassPathXmlApplicationContext("com/xgf/mysql_cache/config/applicationContext.xml");
        //获取bean的两种方式
        // 1.类名首字母小写
//        customerMapper = (CustomerMapper) applicationContext.getBean("customerMapper");
        // 2.类.class
        customerMapper = (CustomerMapper) applicationContext.getBean(CustomerMapper.class);
    }

    //测试一级缓存
    @Test
    public void test01(){

        System.out.println("******第一次查询******");
//        查询数据customerList和customer是前面的声明
        customerList = customerMapper.getCustomerByNameAndJobForWhere(customer);
        System.out.println(customerList);

        //第二次查询(非第一次)，去一级缓存中查询数据，命中：使用一级缓存数据  未命中：发sql去数据库查询
        System.out.println("\n******第二次查询，查询和第一次相同内容(命中：使用一级缓存数据 )******");
        customerList = customerMapper.getCustomerByNameAndJobForWhere(customer);
        System.out.println(customerList);

        System.out.println("\n*****第三次查询，修改查询内容，未命中********");
        customer.setUsername("修改username");
        customer.setJob("修改job");
        customerList = customerMapper.getCustomerByNameAndJobForWhere(customer);
        System.out.println(customerList);
    }
    
}
