<%@ page import="java.io.PrintWriter" %>
<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: xy
  Date: 2020/12/24
  Time: 14:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>response demo</title>
</head>
<body>
<%
    //1，防止中文乱码
    //response.setCharacterEncoding("UTF-8");
    //2，输出
    PrintWriter writer = response.getWriter();
    writer.write("hello");
    writer.write("中国");
    //3，页面跳转
    //response.sendRedirect("shows.jsp");
    //4，页面刷新
    response.setHeader("refresh","1");

%>
<%=new Date()%>
</body>
</html>
