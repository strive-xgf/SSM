package com.xgf.aop.aspectj.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;

/*切面类 定义的一个个方法叫通知
 advice 通知 ---增强的方法，应用于被代理类方法的额外功能
 */

/*
 AspectJ中的切入点匹配的执行点称作连接的（JoinPoint），
在通知方法中可以声明一个JoinPoint类型的参数。通过JoinPoint可以访问连接点的细节
    1.java.lang.Object[] getArgs()：获取连接点方法运行时的入参列表；
    2.Signature getSignature() ：获取连接点的方法签名对象；
    3.java.lang.Object getTarget() ：获取连接点所在的目标对象；
    4.java.lang.Object getThis() ：获取代理对象本身；
    *
    ProceedingJoinPoint继承JoinPoint子接口，它新增了两个用于执行连接点方法的方法：
    5.java.lang.Object proceed() throws java.lang.Throwable：通过反射执行目标对象的连接点处的方法；
    6.java.lang.Object proceed(java.lang.Object[] args) throws java.lang.Throwable：通过反射执行目标对象连接点处的方法，不过使用新的参数替换原来的参数。
* */

public class MyAspect {
//    前置通知  advice
    public void before(JoinPoint joinPoint){
//        被代理对象
        joinPoint.getTarget();
//        目标对象被增强的方法

        //获取方法签名对象   public void save()  【除了{}方法体以外都是方法签名】
        joinPoint.getSignature().getName();
        System.out.println("前置通知，用于权限控制。。"+ joinPoint.getTarget()+" ----methodName---"+joinPoint.getSignature().getName());
    }

    //后置返回通知
    public void afterReturning(JoinPoint joinPoint){
        System.out.println("后置返回通知，清除操作过的文件"+ joinPoint.getTarget()+" ----methodName---"+joinPoint.getSignature().getName());
    }
//  环绕通知 ProceedingJoinPoint是joinPoint的子类
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知，方法执行之前，开启事务");
        joinPoint.proceed();  //让方法继续执行
        System.out.println("环绕通知，方法执行之后，关闭事务");
    }

    public void afterThrowing(Throwable e) throws Throwable {

        System.out.println("异常通知：方法出现异常调用，处理异常"+e.getMessage());

    }

    //最终(后置)通知
    public void after(JoinPoint joinPoint) {
        System.out.println("最终(后置)通知  管理数据库连接等清理工作");

    }

}
