<%--
  Created by IntelliJ IDEA.
  User: xy
  Date: 2020/12/24
  Time: 14:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>展示学生信息</title>
</head>
<body>
<%=request.getAttribute("students")
%>
<%=session.getAttribute("hello2")%>
</body>
</html>
