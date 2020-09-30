package com.xgf.transaction.xml.dao;

import com.xgf.transaction.xml.exception.BookAmmountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("bookStoreDao")
public class BookStoreDaoImpl  implements BookStoreDao {
    /*依赖数据库  Autowired注入jdbcTemplate*/
    @Autowired
    private JdbcTemplate jdbcTemplate;
    /**/
    @Override
    public void sell() throws BookAmmountException {

        String sql = "update bookstore set ammount=ammount-1 where bookname = 'JAVA编程思想'";
        jdbcTemplate.update(sql);
//        int i = 10/0;

        String sql1 = "select ammount from bookstore where bookname = 'JAVA编程思想'";
        /*Integer.class 查询类型是Integer*/
        Integer ammount = jdbcTemplate.queryForObject(sql1,Integer.class);
        /*数量小于0抛出异常*/
        if(ammount < 0){
            throw new BookAmmountException("java编程思想，数量不足");
        }

    }

    @Override
    public Integer get() {

        String sql1 = "select ammount from bookstore where bookname = 'JAVA编程思想'";
        Integer ammount = jdbcTemplate.queryForObject(sql1,Integer.class);
        return ammount;
    }

    @Override
    public void record() {
        String sql1 = "update bookrecord set ammount=ammount+1 where  bookname = 'JAVA编程思想'";
        jdbcTemplate.update(sql1);

    }
}
