package com.xgf.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.xgf.bean.Category;
import com.xgf.bean.Msg;
import com.xgf.service.CategoryService;
import com.xgf.util.JedisUtils;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//通过redis实现分类缓存
@WebServlet("/categoryServlet")
public class CategoryServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //访问redis 较快,但是第一次是没有数据的
        //访问service，获取json，将json保存到redis
        Jedis jedis = JedisUtils.getJedis();
        String json = jedis.get("category_list");

        if (json != null) {
            System.out.println("从 redis cache 中读取数据");
            response.getWriter().println(json);

        } else {
            System.out.println("从 mysql data 中读取数据");
            //创建业务对象
            CategoryService categoryService = new CategoryService();
            //所有的分类
            List<Category> categoryList=categoryService.findAll();
            //显示
            Msg msg = new Msg();
            msg.setCode(200);//200状态码，显示正常
            msg.setData(categoryList);
            json = new ObjectMapper().writeValueAsString(msg);
            //将数据保存到redis
            jedis.set("category_list",json);
            response.getWriter().println(json);
        }
        //关闭连接
        JedisUtils.close(jedis);
    }
}