package com.xgf.aop.aspectj.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;


/*
* 切面类   定义的一个个方法  -  叫通知
* advice 通知 / 增强的方法，
* 应用于被代理类方法的额外功能
* */
// @Component配置 启动容器会实例化类 名字首字母小写myAspect
// @Aspect配置切面
@Aspect
@Component
public class MyAspect {
    /* 配置切点 - pointcut切点
         execution(返回值类型 包名.类名.方法名(参数))
         (..)代表任意参数
    */
    @Pointcut("execution(* com.xgf.aop.aspectj.annotation.*.*(..))")

    public void mycut(){// 切点的id
    }

//    通知  advice
    //@Before("mycut()")    //当有多个值时用value  只有一个属性的时候直接写
    @Before(value="mycut()")
    public void before(JoinPoint joinPoint){
        //JoinPoint对象封装了SpringAop中切面方法的信息,在切面方法中添加JoinPoint参数,就可以获取到封装了该方法信息的JoinPoint对象.

//        获取被代理对象
        joinPoint.getTarget();
//        目标对象被增强的方法
        joinPoint.getSignature().getName();
        System.out.println("前置通知，用于权限控制  被代理对象： "+ joinPoint.getTarget()+" ----方法名methodName---"+joinPoint.getSignature().getName());
    }

    @AfterReturning("mycut()")
    public void afterReturning(JoinPoint joinPoint){
        System.out.println("后置返回通知，清除操作过的文件  被代理对象："+ joinPoint.getTarget()+" ----方法名methodName---"+joinPoint.getSignature().getName());
    }

    @Around("mycut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("环绕通知，方法执行之前，开启事务");
        joinPoint.proceed();//启动目标方法执行
        System.out.println("环绕通知，方法执行之后，关闭事务");
    }

    @AfterThrowing(value = "mycut()",throwing = "e")
    public void afterThrowing(Throwable e) throws Throwable {
        System.out.println("异常通知：方法出现异常调用，处理异常"+e.getMessage());
    }

    @After("mycut()")
    public void after(JoinPoint joinPoint) {
        System.out.println("最终通知  管理数据库连接等清理工作");
    }


}
