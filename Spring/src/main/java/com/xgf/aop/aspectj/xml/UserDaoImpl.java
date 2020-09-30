package com.xgf.aop.aspectj.xml;

// spring AOP 默认使用的aspectJ --> aspectJ默认使用  jdk动态代理  -->  被代理对象和代理对象继承相同的接口
public class UserDaoImpl implements UserDao{
    @Override
    public void save() {
//        int i = 100/0;//异常抛出 虚拟机终止程序运行
        System.out.println("save user .....");
    }
    @Override
    public void delete() {
        System.out.println("delete user .....");
    }
}

