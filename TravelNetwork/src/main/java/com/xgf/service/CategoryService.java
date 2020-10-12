package com.xgf.service;


import com.xgf.bean.Category;
import com.xgf.dao.CategoryDao;
import com.xgf.util.GetDaoUtils;

import java.util.ArrayList;
import java.util.List;

//分类业务
public class CategoryService {
    private static CategoryDao categoryDao = GetDaoUtils.getMapper(CategoryDao.class);
    public List<Category> findAll() {

        //查询所有的分类数据
        List<Category> list =  categoryDao.findAll();
        return list;
    }
}
