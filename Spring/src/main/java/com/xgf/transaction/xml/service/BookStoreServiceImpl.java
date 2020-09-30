package com.xgf.transaction.xml.service;

import com.xgf.transaction.xml.dao.BookStoreDao;
import com.xgf.transaction.xml.exception.BookAmmountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/* service层 处理 事务管理*/
@Service("bookStoreService")
public class BookStoreServiceImpl implements BookStoreService {
    /*Autowired  注入  service操控DAO*/
    @Autowired
    private BookStoreDao bookStoreDao;
    @Autowired
    private BookRecordService bookRecordService;


    @Override
    public void sell()  throws BookAmmountException {
        //调用销售
        bookStoreDao.sell();
        //调用记录
        bookRecordService.record();
    }

    @Override
    public Integer get() {
        return bookStoreDao.get();
    }
}
