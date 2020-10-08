package com.xgf.web.servlet;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.xgf.bean.Msg;
import com.xgf.bean.User;
import com.xgf.service.UserService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

//登录servlet
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    //beanUtils不能自动的将String转换为日期Date类型，通过serialize序列化方法进行的，取出是字符串形式，需要进行格式转换
    //BeanUtils不支持自动将String向Date数据类型转换
    //BeanUtils格式转换器
    static {
        //静态代码块，在加载的时候自动执行，而且只执行一次
        //ConvertUtils.register()方法，将string转date的转换器注册给beanUtils
        //一般写在静态代码块中(只执行一次)，或者在项目启动的时候自己注册(通过监听器实现)
        //将转换器注册到BeanUtils中
        ConvertUtils.register(new Converter() {

            public Object convert(Class type, Object value) {
                //将yyyy-MM-dd格式的字符串转换为Date数据类型
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    return simpleDateFormat.parse(value.toString());
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                return null;
            }
        }, Date.class);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        UserService userService = new UserService();
        HttpSession session = request.getSession();//获取session对象，里面主要是验证码和当前user
        Msg msg = new Msg();//提示信息

        //用户输入的验证码
        String inputCheckCode = request.getParameter("inputCheckCode");
        //从session中获取系统当前生成的验证码
        String verificationCode = (String) session.getAttribute("verificationCode");
        System.out.println("RegisterServlet \t\t inputCheckCode : " + inputCheckCode + " ;\t verificationCode : " + verificationCode);

        //inputCheckCode 与 verificationCode
        //相同表示验证码不正确，将提示信息写到页面的错误提示
        if (inputCheckCode == null || !inputCheckCode.equalsIgnoreCase(verificationCode)) {
            //验证码不看大小写
            msg.setCode(-1);
            msg.setData("验证码输入出错，请重新输入验证码");

            //将字符串转换为json数据格式返回给浏览器
            String json = new ObjectMapper().writeValueAsString(msg);
            response.getWriter().println(json);
            return; //返回不继续执行
        }


        //获取请求参数
        Map<String, String[]> map = request.getParameterMap();
        //当前登录用户
        User registerUser = new User();
        try {
            //参1 javaBean 参2 map 封装bean对象
            BeanUtils.populate(registerUser, map);//将map里面所有的参数赋值给javaBean(login就是输入的username和password)
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用service处理参数，注册业务
        int code = userService.register(registerUser);
        //响应给浏览器 ajax 是响应json给浏览器就可以
        msg.setCode(code);//设置code

        if (code == 1) {
            msg.setData("注册成功，跳转登录界面");
            //从session中删除生成的验证码 不移除的话可能会覆盖新的验证码
            session.removeAttribute("verificationCode");
        } else if(code == 0){
            msg.setData(registerUser.getUsername()+"已注册，请更换用户名");
        }else {
            msg.setData("注册失败");
        }

        //将字符串转成json数据格式，返回给浏览器显示提示信息msg
        String json = new ObjectMapper().writeValueAsString(msg);
        response.getWriter().println(json);
    }
}

