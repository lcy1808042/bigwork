<%--
  Created by IntelliJ IDEA.
  User: xy
  Date: 2020/12/30
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>监听器页面测试</title>
</head>
<body>
<%
    //add
    application.setAttribute("username","zhangsan");
    //update
    application.setAttribute("username","lisi");
    //delete
    application.removeAttribute("username");

    //

    session.setAttribute("username","zhangsan");
    //update
    session.setAttribute("username","lisi");
    //delete
    session.removeAttribute("username");
%>
</body>
</html>
