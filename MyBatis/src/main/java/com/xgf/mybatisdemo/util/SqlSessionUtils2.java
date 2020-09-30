package com.xgf.mybatisdemo.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;

//通过ThreadLocal改造获取SqlSession的工具类SqlSessionUtils(Spring已经封装，可以不使用) - 测试修改
//sqlSession工具类，获取sqlSession  改造SqlSessionUtils，实现dao层与service层解耦 -- 使用的时候只会，删除dao层对service层无影响(删除对另一个无影响)
public class SqlSessionUtils2 {
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

    //通过ThreadLocal改造
    //A: 定义一个ThreadLocal集合，本质是Map<Thread,Object> map
    private   static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();//这个key默认是当前线程，value就是传入的参数SqlSession类型

    public static SqlSession getSession() {

        //查找在当前线程中，是否有对应的SqlSession
        SqlSession sqlSession = threadLocal.get(); //相当于map.get(Thread.currentThread())
        if (sqlSession != null) {
            //当前线程存在SqlSession直接返回给调用者使用
            return sqlSession;
        } else {
            //没有就创建一个新的，并且保存在当前线程中
            sqlSession = sqlSessionFactory.openSession();
            //保存
            threadLocal.set(sqlSession);//实际存储的是threadLocal.set(Thread.currentThread(),sqlSession)
            return sqlSession;//返回
        }
    }

    public static void commitAndClose() {
        //进行修改表操作，需要提交sqlSession才能更新数据库，定义这个方法
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession != null) {
            sqlSession.commit();//提交
            sqlSession.close();//关闭
            //已经关闭的session不能留在threadLocal中
            //所以要删除
            threadLocal.remove();
        }
    }

    //出现错误，回调
    public static void rollbackAndClose() {
        SqlSession sqlSession = threadLocal.get();
        if (sqlSession != null) {
            sqlSession.rollback();//回滚
            sqlSession.close();//释放
            //已经关闭的session不能留在local
            //所以要删除
            threadLocal.remove();
        }
    }

    //通过该方法实现dao和service解耦
    public static <T> T getMapper(Class className) {
        return (T) getSession().getMapper(className);
    }
}

