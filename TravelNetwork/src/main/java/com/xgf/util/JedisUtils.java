package com.xgf.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/*
*   将其编成一个工具类
* */
public class JedisUtils {
    //单例模式 静态代码块只执行一次，因为创建会很消耗性能
    private static JedisPool pool;
    //静态代码在项目中，如果被使用只会加载一次
    static {

        //读src下的文件用类加载器的方式
        InputStream inputStream= JedisUtils.class.getClassLoader().getResourceAsStream("jedis.properties");

        //.properties文件专门的读取工具
        Properties properties = new Properties();
        try {
            //将流中的数据读成map
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 1:创建连接池的配置对象
        JedisPoolConfig config = new JedisPoolConfig();
        //设置最大链接数
        config.setMaxTotal(Integer.parseInt(properties.getProperty("maxTotal")));
        //设置空闲连接数  "3"
        config.setMaxIdle(Integer.parseInt(properties.getProperty("maxIdle")));
        //2:创建连接池
         pool = new JedisPool(config, properties.getProperty("url"), Integer.parseInt(properties.getProperty("port")));
    }
    public static Jedis getJedis() {
//        3:从连接池中获取一个连接
        Jedis jedis = pool.getResource();//获取一个连接
        return jedis;
    }

    public static void close(Jedis jedis) {
        if(jedis!=null){
            jedis.close();
        }
    }
}
