<%--
  Created by IntelliJ IDEA.
  User: xy
  Date: 2020/12/24
  Time: 14:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>session demo</title>
</head>
<body>
<%
    //用户与服务器的一次交互，有时间限制，通常30分钟
    //setAttribute()
    //getAttribute()

    session.setAttribute("hello2","hello session");
    response.sendRedirect("shows2.jsp");
    //使用session可以实现防盗链，只有认证用户可以访问
    //若强制访问  给出提示跳转到登录页面
%>
</body>
</html>
