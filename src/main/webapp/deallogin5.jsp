<%@ page import="java.sql.*" %>

<%@ page import="edu.nifu.sas.dao.UserDao" %>
<%@ page import="edu.nifu.sas.model.User" %><%--
  Created by IntelliJ IDEA.
  User: xy
  Date: 2020/12/21
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    //获取用户输入的用户名密码
    String userName=request.getParameter("username");
    String passWord=request.getParameter("password");

    //创建UserDao
    UserDao userDao = new UserDao();


    //遍历结果集
    if (userDao.checkLogin(new User(userName,passWord))){
        //out.print(resultSet.getString(1)+","+resultSet.getString(2)+","+resultSet.getString(3)+"<br>");
        session.setAttribute("user",userName);
        response.sendRedirect("listStudentsByPaging.jsp");
    }else{
        out.println("<script>alert('用户名密码错误');location.href='login.html'</script>");
    }


%>
