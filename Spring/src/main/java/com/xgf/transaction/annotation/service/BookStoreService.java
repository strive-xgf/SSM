package com.xgf.transaction.annotation.service;

import com.xgf.transaction.annotation.exception.BookAmmountException;

public interface BookStoreService   {
    public void sell() throws BookAmmountException;
    Integer get();
}
