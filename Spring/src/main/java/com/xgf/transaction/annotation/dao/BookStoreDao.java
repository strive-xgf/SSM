package com.xgf.transaction.annotation.dao;

import com.xgf.transaction.annotation.exception.BookAmmountException;

//dao层
public interface BookStoreDao {

    //卖书
    public void sell() throws BookAmmountException;//数量<0 继续卖书就会报错
    //获取书籍数量
    public Integer get();
    //书籍卖出数量
    public void record();
}

