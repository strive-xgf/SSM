package com.xgf.aop.dyanmicProxy.jdk;

/*
* 被代理类
* */
public interface UserDao {

    public void save(String name);  //保存
    public void delete();           //删除
}
