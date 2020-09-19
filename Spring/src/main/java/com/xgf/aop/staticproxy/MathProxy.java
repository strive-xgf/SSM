package com.xgf.aop.staticproxy;
/*
* 代理类--静态代理
*   完成两个工作
* 1、调用业务方法
* 2、添加公共的额外功能
* */
public class MathProxy implements Math {

//    MathImpl mathImpl = new MathImpl();  //业务逻辑
//    Tools tools = new Tools();  //工具类
    MathImpl mathImpl;  //业务逻辑
    Tools tools;  //工具类

//    public MathProxy(){}
    public MathProxy(MathImpl mathImpl, Tools tools) {
        this.mathImpl = mathImpl;
        this.tools = tools;
    }

    @Override
    public int jia(int a, int b) {
        tools.check();
        int result = mathImpl.jia(a,b);
        tools.log();
        return result;
    }

    @Override
    public int jian(int a, int b) {
        tools.check();
        tools.log();
        return mathImpl.jian(a,b);
    }


    //完成两个工作
//    调用业务方法
//    添加公共的额外的功能

//    让MathProxy实现MathImpl相同的方法
}
