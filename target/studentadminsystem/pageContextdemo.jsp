<%--
  Created by IntelliJ IDEA.
  User: xy
  Date: 2020/12/24
  Time: 15:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>pageContextdemo</title>
</head>
<body>
<%
    //可以通过pageContext获取其他八个对象
    JspWriter out1=pageContext.getOut();
    out1.print("hello world");
    ServletRequest request1=pageContext.getRequest();
    ServletResponse response1=pageContext.getResponse();
    response1.getWriter().write("hello");
    Exception exception=pageContext.getException();
    Object page1 = pageContext.getPage();
    ServletConfig servletConfig=pageContext.getServletConfig();
    HttpSession session1=pageContext.getSession();
    ServletContext servletContext=pageContext.getServletContext();

    pageContext.setAttribute("user","pageUser");
    request.setAttribute("user","requestUser");
    session.setAttribute("user","sessionUser");
    application.setAttribute("user","applicationUser");
    out.print(pageContext.findAttribute("user"));
    //使用pageContext.findAttribute()方法查找，范围从小到大
%>
</body>
</html>
