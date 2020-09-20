package com.xgf.transaction.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

/*UserDao模板*/
@Repository
public class UserDaoTemplete {
    /*注入 JdbcTemplate*/
    @Autowired
    private JdbcTemplate jdbcTemplate;
    // 注入事务管理
    @Autowired
    private TransactionTemplate transactionTemplate;

    public void save(){
        transactionTemplate.execute(new TransactionCallback(){
            /*业务逻辑*/
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                String sql = "insert into user(id,username,password,age) values(?,?,?,?)";
                Object[] params = new Object[]{null,"springjdbc - 事务回滚","123456",20};
                jdbcTemplate.update(sql,params);
                int i = 100/0;
                System.out.println("save() - 用户数据保存成功");
                return null;
            }
        });
    }
}
