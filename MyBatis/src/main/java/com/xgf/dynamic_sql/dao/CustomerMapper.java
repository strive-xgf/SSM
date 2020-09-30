package com.xgf.dynamic_sql.dao;


import com.xgf.dynamic_sql.bean.Customer;

import java.util.List;

public interface CustomerMapper {

//    不用标签，普通方法测试- 通过name和job查询Customer
    List<Customer> getCustomerByNameAndJob(Customer customer);
//    通过if标签实现查询
    List<Customer> getCustomerByNameAndJobForIf(Customer customer);
//    通过choose标签实现查询
    List<Customer> getCustomerByNameAndJobForChoose(Customer customer);
//    where标签查询
    List<Customer> getCustomerByNameAndJobForWhere(Customer customer);
//    trim标签
    List<Customer> getCustomerByNameAndJobForTrim(Customer customer);
//    set标签更新数据
    int updateForSet(Customer customer);
//  通过trim+set实现更新数据，添加忽略前后缀实现
    int updateForTrim(Customer customer);
//   通过foreach标签查询 - 参数是list集合id (相当于select * from tableName where id in {1,2,3} 查询结果为集合)
    List<Customer> getCustomerByIdsForeach(List<Integer> ids);
//  bind标签，解决可移植性问题 ，解决不同数据库拼接函数或连接符号的不同(防止sql注入)
    List<Customer> getCustomerByNameAndJobForBind(Customer customer);
//  通过foreach和insert，实现foreach循环批量插入
    boolean insertCustomerList(List<Customer> customerList);
}
