package com.xgf.service;


import com.xgf.bean.User;
import com.xgf.dao.UserDao;
import com.xgf.util.GetDaoUtils;
import com.xgf.util.MailUtils;
import com.xgf.util.UuidUtil;

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
            user.setCode(UuidUtil.getUuid());//生成激活码

            //参1：收件的邮箱  参2：邮箱内容，支持html语句  参3：邮件标题
            MailUtils.sendMail(user.getEmail(),"<a href='http://localhost:8080/TravelNetwork/activeServlet?activeCode="+user.getCode()+"'>点击激活账户</a>","点击激活账户");

            //保存用户注册数据
            userDao.saveUser(user);
            return 1;//未存在，可以注册
        }else {
            return 0;//已存在，不可注册
        }
    }

    //激活 账号激活
    public int active(String activeCode) {
        //判断激活码是否正确

        //激活，更新激活码
        int code =  userDao.updateStatus(activeCode); //1 表示成功

        return code;
    }
}
