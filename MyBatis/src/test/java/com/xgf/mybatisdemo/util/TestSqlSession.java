package com.xgf.mybatisdemo.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;

public class TestSqlSession {

    @Test
    public void test01(){
//        1 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
//        2 创建SqlSessionFactory对象  通过加载配置文件
        InputStream inputStream = TestSqlSession.class.getClassLoader().getResourceAsStream("com/xgf/mybatisdemo/config/mybatis-config.xml");
        SqlSessionFactory sessionFactory = sqlSessionFactoryBuilder.build(inputStream);//加载核心配置文件 参1 输入流

//        3 加载SqlMapConfig.xml配置文件
//        4 创建SqlSession对象
        SqlSession sqlSession = sessionFactory.openSession();
//        5 执行SqlSession对象执行删除
        System.out.println(sqlSession);
        //delete from user where id = ?     参1 是namespace.id(resources资源下的mapper.xml) 参2 参数值
        sqlSession.delete("com.xgf.mybatisdemo.dao.UserMapper.deleteById",1);
//        6 打印结果
//        7 释放资源
        sqlSession.commit();//mybatis的session不会自动提交,必须手动提交
        sqlSession.close();
    }
}
