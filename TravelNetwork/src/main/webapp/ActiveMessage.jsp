<%--
  Created by IntelliJ IDEA.
  User: 帝峰天下
  Date: 2020/10/11
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>激活情况</title>
</head>
<body>
<c:if test="${activeMsg != null && activeMsg == 1}">
    <div style="color: green">激活成功，欢迎您的使用。</div><a href=${pageContext.request.contextPath}/login.jsp title="点击，进入登录页面">前往登录</a>
</c:if>
<c:if test="${activeMsg == null || activeMsg == 0}">
    <div style="color: red">激活失败，请尝试重新激活。</div>
</c:if>

</body>
</html>
