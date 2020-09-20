package com.xgf.aop.dyanmicProxy.cglib;


public class CGLIBTest {
    public static void main(String[] args) {
//       被代理对象
        UserService userService = new UserService();
        MyAspect myAspect = new MyAspect();

        //创建代理对象
        MyProxy myProxy = new MyProxy(userService,myAspect);
        //通过代理类创建被代理对象
        UserService service = (UserService)myProxy.create();

        //调用方法
        service.save();
        service.delete();
    }
}
