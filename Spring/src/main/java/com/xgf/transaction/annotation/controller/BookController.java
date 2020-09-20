package com.xgf.transaction.annotation.controller;

import com.xgf.transaction.annotation.exception.BookAmmountException;
import com.xgf.transaction.annotation.service.BookStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    /*controller里面注入service   通过Autowired类型注入*/
    @Autowired
    private BookStoreService bookStoreService;

    // 卖书  count数量-1
    public void sell(){
        try {
            bookStoreService.sell();
        } catch (BookAmmountException e) {
            //抛出自定义异常
            e.printStackTrace();
        }
    }

    public Integer get(){
        return bookStoreService.get();
    }
}
