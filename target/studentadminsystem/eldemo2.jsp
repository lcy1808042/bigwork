<%--
  Created by IntelliJ IDEA.
  User: xy
  Date: 2020/12/30
  Time: 15:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
你的用户名为：${username},密码为${password}
<%
    String username = (String) request.getAttribute("username");
    String password =(String) request.getAttribute("password");
%>
你的用户名为：<%=username%>,密码为<%=password%>
</body>
</html>
