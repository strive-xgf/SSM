package com.xgf.aop.dyanmicProxy.jdk;

//被代理类
public class UserDaoImpl implements UserDao{
    @Override
    public void save(String name) {
        System.out.println("保存用户成功 ："+name);
    }

    @Override
    public void delete() {
        System.out.println("删除用户成功：");
    }
}
