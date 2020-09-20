package com.xgf.aop.dyanmicProxy.cglib;

/*
* 切面 - 共有方法
* */
public class MyAspect {

    public void check(){
        System.out.println("check方法......检查包");
    }

    public void log(){
        System.out.println("logging方法......记录日志");
    }
}
