package com.xgf.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class MailUtilsTest {

    //测试发送邮箱，谁注册就发送给注册用户的邮箱
    @Test
    public void sendMailTest(){
        //参1：收件的邮箱  参2：邮箱内容，支持html语句  参3：邮件标题
        MailUtils.sendMail("861221293@qq.com","<a href='http://localhost:8080/TravelNetwork/activeServlet?activeCode=d9a421a341fe4ae7b2ca4ccb1062b7b8'>点击激活账户</a>","点击激活账户");
    }

}