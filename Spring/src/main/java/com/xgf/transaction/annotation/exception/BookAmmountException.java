package com.xgf.transaction.annotation.exception;


// 自定义异常  书籍数量异常
public class BookAmmountException extends Exception{

    private String message;
    public BookAmmountException(String message) {
        super(message);
    }
}
