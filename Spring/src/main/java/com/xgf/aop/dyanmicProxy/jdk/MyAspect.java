package com.xgf.aop.dyanmicProxy.jdk;

/*
* 切面类：定义公共方法
* */
public class MyAspect {

    public void check(){
        System.out.println("check user......正在查找用户");
    }

    public void log(){
        System.out.println("logging.....正在记录日志");
    }
}
