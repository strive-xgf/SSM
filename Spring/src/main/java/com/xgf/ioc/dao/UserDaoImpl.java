package com.xgf.ioc.dao;

import com.xgf.ioc.bean.User;
import org.springframework.stereotype.Repository;

/*
@Repository
	该注解用于将数据访问层（DAO）的类标识为Bean，即注解数据访问层Bean，其功能与@Component()相同。
	容器加载就会被实例化
*/
@Repository("userDao")
public class UserDaoImpl implements UserDao {

    @Override
    public void saveUser(User user) {
        System.out.println("调用dao层userDao的saveUser方法，保存用户："+user.getName());
    }
}
