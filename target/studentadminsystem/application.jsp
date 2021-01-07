<%--
  Created by IntelliJ IDEA.
  User: xy
  Date: 2020/12/24
  Time: 15:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>网站访问次数统计</title>
</head>
<body>
<%
    Object count=application.getAttribute("count");
    if(count==null){
        count=1;
        application.setAttribute("count",count);
    }else {
        count=(Integer)count+1;
        application.setAttribute("count",count);
    }
    //page<request<session<application
%>
<h1>
    你是本网站第<%=count%>位访问用户，谢谢
</h1>

</body>
</html>
