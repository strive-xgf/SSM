package com.xgf.aop.dyanmicProxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
* 代理类
* */
public class MyProxy implements InvocationHandler {

    private UserDao userDao;    //被代理类
    private MyAspect myAspect;  //切面类 -- 定义公共方法

    public MyProxy(UserDao userDao, MyAspect myAspect) {
        this.userDao = userDao;
        this.myAspect = myAspect;
    }

    //创建代理对象
    public Object create(){
        ClassLoader classLoader = userDao.getClass().getClassLoader();
//      Class<?>[] interfaces  被代理对象的实现接口
        Class<?>[] interfaces = userDao.getClass().getInterfaces();
        UserDao proxy = (UserDao) Proxy.newProxyInstance(classLoader,interfaces,this);
        System.out.println("创建代理对象create");
        return proxy;
    }

//    调用方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//        织入 advice 加入到 被代理对象方法之前或之后
//        method就是调用的被代理对象的方法
        String methodName = method.getName();
//        Object 被代理对象
//        调用方法
        System.out.println("调用invoke方法");
        myAspect.check();//调用切面方法
        method.invoke(userDao,args);//userDaoImpl.save(参数)
        myAspect.log();//调用切面方法
        return null;
    }
}
