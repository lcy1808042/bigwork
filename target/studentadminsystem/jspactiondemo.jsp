<%--
  Created by IntelliJ IDEA.
  User: xy
  Date: 2020/12/24
  Time: 15:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>jsp action</title>
</head>
<body>
<%
    //jsp:include
    //jsp:forward
    //jsp:include与page include
    //1，功能相同
    //2，include指令是一个静态包含，包含文件与被包含文件合并后组成一个新文件编译执行
    //3，include动作，是一个动态包含，程序执行到包含文件时才动态的引入
    //jsp forward可以直接跳转到其他界面,不能跳转到外部页面
%>
<jsp:forward page="login.html"></jsp:forward>
</body>
</html>
