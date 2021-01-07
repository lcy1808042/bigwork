<%@ page import="edu.nifu.sas.dao.StudentDao" %>
<%@ page import="edu.nifu.sas.dao.impl.StudentDaoImpl" %>
<%@ page import="java.util.List" %>
<%@ page import="edu.nifu.sas.model.Student" %><%--
  Created by IntelliJ IDEA.
  User: xy
  Date: 2020/12/24
  Time: 14:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>request demo</title>
</head>
<body>
<form action="requestdemo.jsp" method="get">
    请输入姓名:<input type="text" name="name"/>
    <input type="submit" value="确定" name="submit"/>
</form>
<%
    String submit=request.getParameter("submit");
    //首次打开本页面submit为null
    //判断submit是否为null
    //不为null表示提交
    if(submit!=null&&submit.equals("确定")){
        out.print(request.getParameter("name"));
        StudentDao studentDao=new StudentDaoImpl();
        List<Student>allStudent=studentDao.getAllStudent();
        //把学生信息放入request
        request.setAttribute("students",allStudent);
        //request.setAttribute("students","allStudent");
        //页面跳转
        request.getRequestDispatcher("shows.jsp").forward(request,response);
    }
%>
</body>
</html>
