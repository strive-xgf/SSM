package com.xgf.transaction.xml.service;


import com.xgf.transaction.xml.dao.BookStoreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("bookRecordService")
public class BookRecordService {

    @Autowired

    private BookStoreDao bookStoreDao;

    public  void record(){

        bookStoreDao.record();
//        int i =  100/0;

    }
}
