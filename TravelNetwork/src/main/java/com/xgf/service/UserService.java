package com.xgf.service;


import com.xgf.bean.User;
import com.xgf.dao.UserDao;
import com.xgf.util.GetDaoUtils;

//user业务层
public class UserService {

    private static UserDao userDao = GetDaoUtils.getMapper(UserDao.class);

    //登录用户
    public int login(User user) {

        User u = userDao.getUserByUsernamePassword(user);
        //System.out.println(" ======UserService - login ====== "+ u );
        if(u == null){
            return -1;  //账号密码匹配找不到
        }else {
            //判断用户user是否激活
            if(u.getStatus().equals("Y")){
                return 1;   //账号密码正确，且已经激活
            }else {
                return -2;  //账号未激活
            }
        }
    }

    public int register(User user) {

        //查找username是否存在，存在就返回错误，不能注册
        User u = userDao.findByUserName(user.getUsername());
        if(u == null){
            user.setStatus("N");//注册成功，但是设置为未激活

            //通过UUID获取一个激活码
            //user.setCode(activeCode);//激活
            //保存用户注册数据
            userDao.saveUser(user);
            return 1;//未存在，可以注册
        }else {
            return 0;//已存在，不可注册
        }


    }
}
