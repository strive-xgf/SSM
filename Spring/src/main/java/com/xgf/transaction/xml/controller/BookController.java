package com.xgf.transaction.xml.controller;

import com.xgf.transaction.xml.service.BookStoreService;
import com.xgf.transaction.xml.exception.BookAmmountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class BookController {

    /*controller里面注入service   通过Autowired类型注入*/
    @Autowired
    private BookStoreService bookStoreService;

    /*买书 数量--*/
    public void sell(){
        try {
            bookStoreService.sell();
        } catch (BookAmmountException e) {
            e.printStackTrace();
        }
    }

    public Integer get(){
        return bookStoreService.get();
    }
}
