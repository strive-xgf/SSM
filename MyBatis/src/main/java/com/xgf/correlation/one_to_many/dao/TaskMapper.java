package com.xgf.correlation.one_to_many.dao;



import com.xgf.correlation.one_to_many.bean.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskMapper {

    //通过useId查询当前user的task列表
    public List<Task> getTaskListByUid(Integer uid);
}
