<%@ page import="edu.nifu.sas.dao.StudentDao" %>
<%@ page import="edu.nifu.sas.dao.impl.StudentDaoImpl" %>
<%@ page import="edu.nifu.sas.util.PageUtil" %>
<%@ page import="edu.nifu.sas.model.Student" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: xy
  Date: 2020/12/24
  Time: 13:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生列表展示</title>
    <link rel="stylesheet" href="./bootstrap-5.0.0-beta1-dist/css/bootstrap.css">

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
<h1 align="center">软件工程18级学生信息表</h1>
<hr>
<form action="searchStudentServlet" method="post">
    请输入姓名查询信息：<input type="text" id="userName" name="userName">
    <input type="submit" value="确定" id="submit" name="submit">
</form>

<form action="registerStudent.jsp" method="post">

    <input type="submit" value="新学生注册" id="submit2" name="submit">
</form>
<hr>
<table class="table table-bordered table-striped">

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
        request.setCharacterEncoding("UTF-8");

        String submit=request.getParameter("submit");
        List<Student>students=null;


        String page1=request.getParameter("page");
        int pageSize=5;
        long totalRecords=0;
        int currentPage=0;
        //判断page是否存在?page1==null设置page1=1，初始值设置为第1页
        if(page1==null){
            page1="1";
        }
        currentPage=Integer.parseInt(page1);
        StudentDao sdao=new StudentDaoImpl();
        //获取并优化总记录数,把总记录数保存到request中
        Object totals=request.getAttribute("totals");
        if(totals==null){
            totalRecords=sdao.totalRecords();
            request.setAttribute("totals",totalRecords);
        }else{
            totalRecords=(Long)totals;
        }
        //创建PageUtil对象
        PageUtil pageUtil=new PageUtil(totalRecords,pageSize,currentPage);
        out.print(pageUtil.getCurrentPage());
          students=sdao.getStudentByPaging(pageUtil.getCurrentPage(),pageSize);


//        String submit=request.getParameter("submit");
//        if(submit!=null && submit.equals("确定")){
//            //查询处理
//            //获取字符串
//            String name=request.getParameter("userName");
//            //调用查询结果
//            students=sdao.getStudentByName(name);
//        } else{
//            students=sdao.getAllStudent();
//        }

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
        <td>
        <a href="deleteStudent.jsp?stuno=<%=s.getStuNo()%>">删除</a>
        </td>
    </tr>
    <% }%>
</table>
<hr>
<%@include file="page.jsp"%>
</body>
</html>
