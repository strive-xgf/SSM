package com.xgf.ioc.service;


import com.xgf.ioc.bean.User;
import com.xgf.ioc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
    @Service
	该注解用于标注一个业务逻辑组件类（Service层），其功能与@Component()相同。
    value是默认bean的id
    容器加载后会实例化，创建UserService对象
*/
@Service(value="userService")
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }
}
