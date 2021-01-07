<%@ page import="edu.nifu.sas.model.Student" %>
<%@ page import="edu.nifu.sas.dao.impl.StudentDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: xy
  Date: 2020/12/25
  Time: 10:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
    <link rel="stylesheet" href="./bootstrap-5.0.0-beta1-dist/css/bootstrap.css">
</head>
<body align="center">
<h1>确定删除该学生信息吗？</h1>
<%
    String stuno=request.getParameter("stuno");
    //out.print(stuno);
    Student student=null;
    if(stuno==null){
        out.print("<script>alert('未获取到学生信息，请先选择需要修改的学生');location.href='listStudents.jsp'</script>");
    }else{
        student=new StudentDaoImpl().getStudentByNo(stuno);
    }
%>
<form action="deleteStudentServlet" method="post" class="table-bordered table-striped">
    <input type="text" id="stuno" name="stuno" value="<%=student.getStuNo()%>" readonly> <br>
    <input type="text" id="stuname" name="stuname" value="<%=student.getStuName() %>"readonly><br>
    <input type="text" id="classes" name="classes" value="<%=student.getClasses() %>"readonly><br>
    <input type="text" id="gender" name="gender" value="<%=student.getGender() %>"readonly><br>
    <input type="text" id="department" name="department" value="<%=student.getDepartment() %>"readonly><br>
    <input type="text" id="tel" name="tel" value="<%=student.getTel()%>"><br>
    <input type="text" id="dormno" name="dormno" value="<%=student.getDormNo() %>"readonly><br>
    <input type="submit" value="确定" name="submit">
</form>
</body>
</html>
