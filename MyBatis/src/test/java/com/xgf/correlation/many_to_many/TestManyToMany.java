package com.xgf.correlation.many_to_many;


import com.xgf.correlation.many_to_many.bean.Order;
import com.xgf.correlation.many_to_many.dao.OrderMapper;
import com.xgf.correlation.one_to_many.bean.User;
import com.xgf.correlation.one_to_many.dao.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//测试类
public class TestManyToMany {

    private static ApplicationContext applicationContext = null;
    private static OrderMapper orderMapper = null;

    //静态代码块 只加载一次
    static {
        //加载配置文件
        applicationContext = new ClassPathXmlApplicationContext("com/xgf/correlation/many_to_many/config/applicationContext.xml");
        //获取bean的两种方式
        // 1.类名首字母小写
//        studentMapper = (StudentMapper) applicationContext.getBean("orderMapper");
        // 2.类.class
        orderMapper = (OrderMapper) applicationContext.getBean(OrderMapper.class);
    }

    //// 通过order订单的id查询订单，并输出该订单的所有产品product
    @Test
    public void test01(){
        System.out.println("===一条SQL语句查询  查找id为1的order和他的product列表：===");
        Order order = orderMapper.getOrderById(1);
        System.out.println(order);
    }
}
