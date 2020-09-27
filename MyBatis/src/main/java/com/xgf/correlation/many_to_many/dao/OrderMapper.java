package com.xgf.correlation.many_to_many.dao;


import com.xgf.correlation.many_to_many.bean.Order;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {
// 通过order订单的id查询订单，并输出该订单的所有产品product
    Order getOrderById(int i);
}
