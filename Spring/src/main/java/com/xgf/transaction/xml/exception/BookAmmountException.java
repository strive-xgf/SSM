package com.xgf.transaction.xml.exception;

/*
* 书籍数量异常
* */
public class BookAmmountException extends Exception{

    private String message;
    public BookAmmountException(String message) {
        super(message);
    }
}
