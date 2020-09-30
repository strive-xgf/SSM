package com.xgf.mybatisdemo.util;

import com.xgf.mybatisdemo.bean.User;
import com.xgf.mybatisdemo.dao.UserMapper;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.sql.Date;
import java.util.List;


//测试工具类SqlSessionUtil能否获取SqlSession  并进行增删拆改
public class TestSqlSessionUtils {

    private SqlSession sqlSession = null;
    private UserMapper userMapper = null;
    //@Before 在每个方法执行前获取session
    @Before
    public void init(){
        //通过SqlSessionUtils工具类获取sqlSession
        sqlSession = SqlSessionUtils.getSession();
        userMapper = sqlSession.getMapper(UserMapper.class);
    }

    //测试查询
    @Test
    public void test01(){
        System.out.println("查找user");
        User user = userMapper.getUserById(2);
        System.out.println(user);
    }

    //(对数据库进行修改需要提交事务(insert、update、delete))
    //测试增加
    @Test
    public void test02(){
        // mybatis动态代理会自动生成userMapper的实现类，查询sql，执行jdbc代码
        System.out.println("增加user");
        User user = new User(null,"添加username", Date.valueOf("2020-12-15"), 1, "湖南省张家界市");
        userMapper.saveUser(user);
        sqlSession.commit();
    }

    //测试删除
    @Test
    public void test03(){
        System.out.println("删除id=1的user");
        userMapper.deleteById(1);
        //sqlSession执行数据更新(增加、删除、修改)需要提交事务commit才会对数据库进行修改，查询不需要提交事务
        sqlSession.commit();
    }

    //测试通过模糊查询 username
    @Test
    public void test04(){
        System.out.println("查询用户名中含有name的所有user");
        List<User> userList = userMapper.findByUsername("%name%");
        for(User user:userList){
            System.out.println(user);
        }
    }

    //测试更新
    @Test
    public void test05(){
        System.out.println("更新id=7的数据");
        int i = userMapper.updateUser(new User(7, "我更新了7的user", Date.valueOf("2020-2-22"), 2, "我的address在湖南"));

        if(i>0){
            sqlSession.commit();
            System.out.println("更新了" + i + "条数据");

        }else{
            System.out.println(" id =7 的用户不存在，数据更新失败");
        }

    }

    //每个方法执行之后执行
    @After
    public void destory(){
        sqlSession.close();//关闭sqlSession
    }

}
