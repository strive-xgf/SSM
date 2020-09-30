package com.xgf.mybatisdemo.dao;

import com.xgf.mybatisdemo.bean.User;
import org.apache.ibatis.annotations.Delete;

import java.util.List;


//创建User类的映射文件
public interface UserMapper {
    //通过id查找user
    public User getUserById(int id);

    //通过模糊搜索，找到对应的用户名
    //    select * from user where username like '张%'
    List<User> findByUsername(String username);

    //通过id删除user
    public void deleteById(int id);

    //添加user
    public void saveUser(User user);

    //更新user
    public int updateUser(User user);
}
