<%@ page import="edu.nifu.sas.dao.StudentDao" %>
<%@ page import="edu.nifu.sas.dao.impl.StudentDaoImpl" %>
<%@ page import="edu.nifu.sas.model.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: xy
  Date: 2020/12/23
  Time: 17:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生列表</title>
</head>
<style>
    img{
        width: 100px;
        height: 100px;
    }
    table {
        border: 1px solid black;
        width: 70%;
        margin: 0 auto;
        border-collapse: collapse;
    }
    tr{
        border: 1px solid black;
        width: 70%;
        margin: 0 auto;
        border-collapse: collapse;
    }
</style>
<body>
<h1 align="center">软件工程18级学生信息表</h1>
<hr>
<form action="listStudentsByPaging.jsp" method="post">
    请输入姓名：<input type="text" id="userName" name="userName">
    <input type="submit" value="确定" id="submit" name="submit">
</form>
<hr>
<table>

    <tr>
        <td>学号</td>
        <td>姓名</td>
        <td>班级</td>
        <td>性别</td>
        <td>系部</td>
        <td>电话</td>
        <td>宿舍号</td>
        <td>照片</td>
        <td>操作</td>
        <td>操作</td>
    </tr>
    <%

        //从request中获取数据
        List<Student> students =(List<Student>) request.getAttribute("students");
        if(students!=null)
        for(Student s:students){
    %>

    <tr>
        <td><%=s.getStuNo()%></td>
        <td><%=s.getStuName()%></td>
        <td><%=s.getClasses()%></td>
        <td><%=s.getGender()%></td>
        <td><%=s.getDepartment()%></td>
        <td><%=s.getTel()%></td>
        <td><%=s.getDormNo()%></td>
        <td><img src="<%=s.getPhotoPath()%>" ></td>
        <td>

            <a href="updatestudent.jsp?stuno=<%=s.getStuNo()%>">修改</a>
        </td>
        <td><a href="deleteStudent.jsp?stuno=<%=s.getStuNo()%>">删除</a></td>
    </tr>
    <% }%>
</table>
</body>
</html>
