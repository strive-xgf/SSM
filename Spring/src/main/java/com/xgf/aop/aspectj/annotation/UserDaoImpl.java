package com.xgf.aop.aspectj.annotation;

import org.springframework.stereotype.Repository;

@Repository("userDao")
public class UserDaoImpl implements UserDao {
    @Override
    public void save() {
        //int i = 100/0;//异常抛出 虚拟机终止程序运行
        System.out.println("save 保存 ......");
    }
    @Override
    public void delete() {
        System.out.println("delete 删除 ......");
    }
}
