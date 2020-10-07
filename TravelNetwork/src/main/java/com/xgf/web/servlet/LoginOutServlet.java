package com.xgf.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

//退出登录并注销cookie
@WebServlet("/loginOutServlet")
public class LoginOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cookie[] userCookies = request.getCookies();

        for(Cookie cookie : userCookies){
            if(cookie.getName().equals("username")){
                cookie.setMaxAge(0);//设置cookie生存期为0
                //将cookie发送给服务器
                response.addCookie(cookie);
            }else if(cookie.getName().equals("password")){
                cookie.setMaxAge(0);
                //将cookie发送给服务器
                response.addCookie(cookie);
            }
        }
        //查找session
        HttpSession session = request.getSession();
        //让session销毁或者过期
        session.invalidate();
         //重定向 login.jsp
        response.sendRedirect(request.getContextPath()+"/login.jsp");
    }
}
