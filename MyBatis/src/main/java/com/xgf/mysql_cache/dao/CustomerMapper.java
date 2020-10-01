package com.xgf.mysql_cache.dao;


import com.xgf.mysql_cache.bean.Customer;

import java.util.List;

public interface CustomerMapper {

//    where标签查询数据 name和job满足条件
    List<Customer> getCustomerByNameAndJobForWhere(Customer customer);

}
