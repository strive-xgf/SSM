package com.xgf.transaction.xml.dao;

import com.xgf.transaction.xml.exception.BookAmmountException;

public interface BookStoreDao {

    //卖出书籍
    public void sell()  throws BookAmmountException;
    //获取当前书籍剩余数量
    Integer get();
    //书籍卖出记录情况
    void record();
}
