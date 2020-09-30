package com.xgf.transaction.annotation.service;

import com.xgf.transaction.annotation.dao.BookStoreDao;
import com.xgf.transaction.annotation.exception.BookAmmountException;
import com.xgf.transaction.annotation.service.BookRecordService;
import com.xgf.transaction.annotation.service.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/* service层 处理 事务管理*/
@Service("bookStoreService")
public class BookStoreServiceImpl implements BookStoreService {
    /*Autowired  注入  service操控DAO*/
    @Autowired
    private BookStoreDao bookStoreDao;
    @Autowired
    private BookRecordService bookRecordService;

//      spring事务回滚处理的是运行时异常，自定义异常类继承Exception不是运行时异常，事务不回滚
//          解决办法：1.自定义异常类继承运行时异常RuntimeExcption
//                  2.@Transactional注解放入@Transactional回滚属性，添加自定义异常类
                //rollbackFor回滚异常  noRollbackFor不回滚异常2
/*  propagation事务的传播特性
    当一个开启了事务的方法调用另外一个方法时候，被调用的方法如何处理事务

*/
    @Override
    @Transactional(rollbackFor={BookAmmountException.class},
                   noRollbackFor = {ArithmeticException.class},
                   propagation= Propagation.REQUIRED)
    public void sell()  throws  BookAmmountException{
        //调用销售
        bookStoreDao.sell();
        //调用记录
        bookRecordService.record();
    }

    //Isolation.READ_COMMITTED 这是默认情况  已提交读
    //  Isolation.READ_UNCOMMITTED 当一个线程操作一个数据的时候，另外一个线程读到了未提交的数据
    @Override
    @Transactional(isolation= Isolation.READ_COMMITTED)
    public Integer get() {
        return bookStoreDao.get();
    }
}
