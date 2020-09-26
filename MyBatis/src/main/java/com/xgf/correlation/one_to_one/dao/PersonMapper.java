package com.xgf.correlation.one_to_one.dao;


import com.xgf.correlation.one_to_one.bean.Person;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonMapper {

    //通过一条Sql语句来查询
    Person getPersonById(int id);

    //通过嵌套查询
    Person getPersonById2(int id);

    //通过用户名查询
    Person getPersonByName(String username);
}
