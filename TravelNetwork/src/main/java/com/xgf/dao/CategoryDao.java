package com.xgf.dao;


import com.xgf.bean.Category;

import java.util.List;

public interface CategoryDao {
    //获取所有的分类，按照升序排序
    //select * from tab_category order by cid asc;
    List<Category> findAll();

    //通过id查找Category
    //select * from  tab_category c where c.cid =1;
    Category findOneByCid(int cid);
}
