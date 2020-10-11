package com.xgf.web.servlet;



import com.xgf.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//激活user
@WebServlet("/activeServlet")
public class ActiveServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserService userService = new UserService();
        //获取参数  activeCode
        //这个激活码，是发送给用户邮箱后面带的参数，比如 /TravelNetwork/activeServlet?activeCode=0c16da9b54494cc7954bcfef25542bfb
        String activeCode = request.getParameter("activeCode");
        //处理参数，激活用户
        int code = userService.active(activeCode);
        System.out.println("activeCode = " + activeCode);
        //将激活情况响应给浏览器
        int activeMsg = 0;
        if(code==1){
            activeMsg = 1;
            //跳转登录界面
            //response.sendRedirect(request.getContextPath() + "/login.jsp");
        }else{
            activeMsg = 0;
        }
        request.setAttribute("activeMsg",activeMsg);
        //激活成功跳转响应界面
        request.getRequestDispatcher("ActiveMessage.jsp").forward(request,response);
    }
}
