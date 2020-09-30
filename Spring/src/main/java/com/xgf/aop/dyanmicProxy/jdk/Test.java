package com.xgf.aop.dyanmicProxy.jdk;

/*
* 测试类：
*   生成代理类的时候要用到被代理类和切面
* jdk动态代理是在运行时生成代理类
* 代理类是和被代理类实现相同的接口
* */
public class Test {

    public static void main(String[] args) {

//      被代理类
        UserDao userDao = new UserDaoImpl();
//      切面
        MyAspect myAspect = new MyAspect();

        //创建代理类  参1：被代理类  参2：切面(公共方法)
        MyProxy myProxy = new MyProxy(userDao,myAspect);
        //通过代理类来创建实例 - 代理对象
        UserDao proxy = (UserDao)myProxy.create();

        proxy.save("GF_浪夏一学");
        proxy.delete();
    }
}
