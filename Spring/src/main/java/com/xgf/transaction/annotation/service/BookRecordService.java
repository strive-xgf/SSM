package com.xgf.transaction.annotation.service;

import com.xgf.transaction.annotation.dao.BookStoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("bookRecordService")
public class BookRecordService {

    @Autowired

    private BookStoreDao bookStoreDao;

    // 当前方法和调用的方法处于同一个事务,当前面事务回滚，当前事务也回滚，sell和record都回滚
    @Transactional(propagation= Propagation.REQUIRED)
//@Transactional(propagation= Propagation.REQUIRES_NEW)// 当前方法重新开启一个新事物，自己单独处理事务提交，回滚，sell回滚，record不回滚，record当做是单独的事务
    public  void record(){

        bookStoreDao.record();
        //int i =  100/0;

    }
}
