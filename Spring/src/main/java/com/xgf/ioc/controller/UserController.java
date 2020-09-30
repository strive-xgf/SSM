package com.xgf.ioc.controller;


import com.xgf.ioc.bean.User;
import com.xgf.ioc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;


//spring容器启动的时候扫描注解，实例化所有的bean

/*
    @Controller注解  该注解用于标注一个控制器组件类
    容器一启动就会实例化  创建好之后以类名首字母小写放到容器中
    UserController 启动容器之后  创建好之后 变成---> key= userController value=new UserController();
* */
@Controller
public class UserController {
    /*
    @Autowired注解 按照类型进行匹配  - 自动装载
    该注解可以对类成员变量、方法及构造方法进行标注，完成自动装配的工作。
    通过 @Autowired的使用来消除setter 和getter方法。默认按照Bean的类型进行装配。
    */
    @Autowired
    private UserService userService;//  香当于执行了实例化  private UserService userService = new UserServiceImpl();

    //调用service的方法saveUser
    public void saveUser(User user){
        userService.saveUser(user);
    }


}
