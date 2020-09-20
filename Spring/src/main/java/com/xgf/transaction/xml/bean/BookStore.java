package com.xgf.transaction.xml.bean;

/* 数据库
    书籍仓库
    BookStore类
    */
public class BookStore {

    private Integer id;
    private String bookname;
    private Integer ammount;

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
