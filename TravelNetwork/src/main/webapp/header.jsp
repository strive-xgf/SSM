<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
<!-- 头部 start -->
    <header id="header">
        <div class="top_banner">
            <img src="images/top_banner.jpg" alt="头部导航栏">
        </div>
        <div class="shortcut">
            <!-- 登录状态  -->
            <div class="login" style="margin-left: -100px">
    <%--            将session中的用户数据取出来 --%>
    <%--            判断用户对象是否为空  如果是提示请登录，否则显示用户信息--%>
             <!-- 登录显示  -->
                <c:if test="${user != null}">
                    <span>欢迎使用，${user.username}</span>
                    <a href="myfavorite.jsp" class="collection">我的收藏</a>
                    <a href="${pageContext.request.contextPath}/loginOutServlet">退出</a>
                </c:if>
            <!-- 未登录显示  -->
                <c:if test="${user == null}">
                    <span>您还没有登录</span>
                    <a href="login.jsp">登录</a>
                    <a href="register.jsp">注册</a>
                </c:if>

            </div>
        </div>
        <div class="header_wrap">
            <div class="topbar">
                <div class="logo">
                    <a href="/"><img src="images/logo.jpg" alt=""></a>
                </div>
                <div class="search">
                    <input name="" type="text" placeholder="请输入路线名称" class="search_input" autocomplete="off">
                    <a href="javascript:;" class="search-button">搜索</a>
                </div>
                <div class="hottel">
                    <div class="hot_pic">
                        <img src="images/hot_tel.jpg" alt="">
                    </div>
                    <div class="hot_tel">
                        <p class="hot_time">客服热线(9:00-6:00)</p>
                        <p class="hot_num">400-000-0000</p>
                    </div>
                </div>
            </div>
        </div>
    </header>
    <!-- 头部 end -->
     <!-- 首页导航 -->
    <div class="navitem">
        <ul class="nav">
            <li class="nav-active"><a href="index.jsp">首页</a></li>
            <li><a href="route_list.html">门票</a></li>
            <li><a href="route_list.html">酒店</a></li>
            <li><a href="route_list.html">香港车票</a></li>
            <li><a href="route_list.html">出境游</a></li>
            <li><a href="route_list.html">国内游</a></li>
            <li><a href="route_list.html">港澳游</a></li>
            <li><a href="route_list.html">抱团定制</a></li>
            <li><a href="route_list.html">全球自由行</a></li>
            <li><a href="favoriterank.html">收藏排行榜</a></li>
        </ul>
    </div>
</body>
</html>