package com.xgf.mybatisdemo.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

//sqlSession工具类，获取sqlSession
public class SqlSessionUtils {

    //SqlSessionFactory对象
    private static SqlSessionFactory sqlSessionFactory;

    //static 静态代码，在类加载的时候执行一次，且只执行一次
    static{
        //1. 创建SqlSessionFactoryBuilder对象
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //2. 加载mybatis-config.xml配置文件   参数：核心配置文件
        InputStream inputStream = SqlSessionUtils.class.getClassLoader().getResourceAsStream("com/xgf/mybatisdemo/config/mybatis-config.xml");
        //3. 创建SqlSessionFactory对象  加载核心配置文件  参数：输入流
        sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);

    }

    public static SqlSession getSession(){
        // 4. 创建SqlSession对象  对数据库进行操作
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }
}
