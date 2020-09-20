package com.xgf.transaction.xml.service;

import com.xgf.transaction.xml.exception.BookAmmountException;

public interface BookStoreService   {
    public void sell() throws BookAmmountException;
    Integer get();
}
