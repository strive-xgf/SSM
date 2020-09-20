package com.xgf.transaction.annotation;

import com.xgf.transaction.annotation.controller.BookController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {

        ApplicationContext context =
                new ClassPathXmlApplicationContext("com/xgf/transaction/annotation/applicationContext.xml");
        BookController bookController = (BookController) context.getBean("bookController");
        Integer ammount1 = bookController.get();//获取书籍数量
        System.out.println("当前库存书籍数量： " + ammount1);
        System.out.println(" === 卖出一本书 === ");
        bookController.sell();//卖出一本书籍
        Integer ammount2 = bookController.get();//获取书籍数量
        System.out.println("当前库存书籍数量： " + ammount2);
    }
}
