package com.xgf.aop.dyanmicProxy.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/*
* 泛型  ---> 被代理类  通用
* */
public class MyProxy<T> implements MethodInterceptor {

    private T byProxy;          //被代理类
    private MyAspect myAspect;  //切面

    public MyProxy(T byProxy, MyAspect myAspect) {
        this.byProxy = byProxy;
        this.myAspect = myAspect;
    }

//    创建代理对象
    public T create(){
        // 通国Enhancer创建代理类 ----  Proxy
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(byProxy.getClass());
        enhancer.setCallback(this);//实现MethodInterceptor接口的对象，就是当前对象
        T proxy = (T)enhancer.create();
        return proxy;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {

//        Method method,调用的被代理对象方法
        String methodName = method.getName();
        if(methodName.equals("save")){
            myAspect.check();
            method.invoke(byProxy,objects);
            myAspect.log();
        }
        if(methodName.equals("delete")){
            myAspect.check();
            method.invoke(byProxy,objects);
            myAspect.log();
        }
        return null;
    }
}
