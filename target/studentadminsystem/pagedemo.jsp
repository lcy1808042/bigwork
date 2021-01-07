<%--
  Created by IntelliJ IDEA.
  User: xy
  Date: 2020/12/24
  Time: 15:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>page demo</title>
</head>
<body>
<%=page.hashCode()
%><br>
<%=page%>
<%
    //什么是hashCode:内存地址经过hash函数后得到的数值，是内存地址经过hash函数变化后的结果
    //hashCode的作用：为了快速查找对象

%>

</body>
</html>
