package com.xgf.correlation.one_to_one.dao;



import com.xgf.correlation.one_to_one.bean.Card;
import org.springframework.stereotype.Repository;

@Repository
public interface CardMapper {

    //通过id来查询身份证表Card的信息
    public Card getCardById(Integer id);
}
