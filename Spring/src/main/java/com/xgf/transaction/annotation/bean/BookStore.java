package com.xgf.transaction.annotation.bean;

// 书籍仓库类
public class BookStore {

    private Integer id;         //编号
    private String bookname;    //书名
    private Integer ammount;    //数量

    public BookStore(Integer id, String bookname, Integer ammount) {
        this.id = id;
        this.bookname = bookname;
        this.ammount = ammount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Integer getAmmount() {
        return ammount;
    }

    public void setAmmount(Integer ammount) {
        this.ammount = ammount;
    }

    @Override
    public String toString() {
        return "BookStore{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", ammount=" + ammount +
                '}';
    }
}
