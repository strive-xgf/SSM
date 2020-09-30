package com.xgf.correlation.one_to_many;


import com.xgf.correlation.one_to_many.bean.User;
import com.xgf.correlation.one_to_many.dao.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//测试类
public class TestOneToMany {

    private static ApplicationContext applicationContext = null;
    private static UserMapper userMapper = null;

    //静态代码块 只加载一次
    static {
        //加载配置文件
        applicationContext = new ClassPathXmlApplicationContext("com/xgf/correlation/one_to_many/config/applicationContext.xml");
        //获取bean的两种方式
        // 1.类名首字母小写
//        studentMapper = (StudentMapper) applicationContext.getBean("userMapper");
        // 2.类.class
        userMapper = (UserMapper) applicationContext.getBean(UserMapper.class);
    }

    //第一种(getUserTaskById)直接通过id一条SQL语句查询
    @Test
    public void test01(){
        System.out.println("===一条SQL语句查询  查找id为100001的user和他的task列表：===");
        User user = userMapper.getUserTaskById(100001);
        System.out.println(user);
    }

    //第二种(getUserTaskById2)通过嵌套查询实现
    @Test
    public void test02(){
        System.out.println("===嵌套查询  查找id为100002的user和他的task列表===");
        User user = userMapper.getUserTaskById2(100002);
        System.out.println(user);
    }


}
