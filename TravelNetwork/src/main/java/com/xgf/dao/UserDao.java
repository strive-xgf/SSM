package com.xgf.dao;

import com.xgf.bean.User;

public interface UserDao {
    // 通过usernmae和password查询用户
    public User getUserByUsernamePassword(User user);

    //通过usernmae查询user是否存在
    User findByUserName(String username);

    //保存用户注册数据，添加用户
    void saveUser(User user);
}
