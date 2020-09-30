package com.xgf.correlation.one_to_many.dao;



import com.xgf.correlation.one_to_many.bean.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserMapper {

    //1.一条sql查询(通过内连接、外连接)
    User getUserTaskById(int id);
    //2.嵌套查询，分布查询加载【推荐】
    User getUserTaskById2(int id);
}
