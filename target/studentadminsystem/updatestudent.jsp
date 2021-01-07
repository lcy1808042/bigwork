<%@ page import="edu.nifu.sas.model.Student" %>
<%@ page import="edu.nifu.sas.dao.impl.StudentDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: xy
  Date: 2020/12/23
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新</title>
    <link rel="stylesheet" href="./bootstrap-5.0.0-beta1-dist/css/bootstrap.css">
</head>
<body align="center">
<h1>修改学生信息</h1>
<%
    String stuno=request.getParameter("stuno");
    out.print(stuno);
    Student student=null;
    if(stuno==null){
        out.print("<script>alert('未获取到学生信息，请先选择需要修改的学生');location.href='listStudents.jsp'</script>");
    }else{
        student=new StudentDaoImpl().getStudentByNo(stuno);
    }
%>
<form action="updateUserInfoServlet" method="post"  class="table-striped table-striped table-bordered">
    请输入学号:<input type="text" id="stuno" name="stuno" value="<%=student.getStuNo()%>" readonly> <br>
    请输入姓名:<input type="text" id="stuname" name="stuname" value="<%=student.getStuName()%>"><br>
    请输入班级:<select name="classes" id="classes">
    <option value="1808041">软件工程1808041</option>
    <option value="1808042">软件工程1808042</option>
    <option value="j1808011">计算机应用技术1808011</option>
    <option value="j1808012">计算机应用技术1808012</option>
</select>
    <br>
    请输入性别:<select id="gender" name="gender">
    <%
        if (student.getGender().equals("男")){
    %>
    <option value="男" selected>男</option>
    <option value="女">女</option>
    <%
    }else{
    %>
    <option value="男">男</option>
    <option value="女" selected>女</option>
    <%
        }
    %>
</select>
    <br>
    请选择系部:<select id="department" name="department">
    <option value="软件工程">软件工程</option>
    <option value="计算机应用">计算机应用</option>
</select>
    <br>
    请输入电话:<input type="text" id="tel" name="tel" value="<%=student.getTel()%>"><br>
    请输入宿舍:<select id="dormno" name="dormo">
    <option value="3-101">3-101</option>
    <option value="10410">10410</option>
    <option value="10536">10536</option>
    <option value="10425">10425</option>
    <option value="10408">10408</option>

</select>
    <br>
    <%
        // }
    %>
    <script>
        function addSelected(ele,value){
            var options=ele.options;
            for(option of options){
                if(option.value==value){
                    option.selected=true;
                }
            }
        }
        //更新班级信息
        var classes=document.getElementById("classes");
        addSelected(classes,"<%=student.getClasses()%>");
        //更新系部
        var deparment=document.getElementById("department");
        addSelected(deparment,"<%=student.getDepartment()%>");
        //更新宿舍
        var dormno=document.getElementById("dormno");
        addSelected(dormno,"<%=student.getDormNo()%>");
    </script>
    <input type="submit" value="提交" name="submit">
</form>
<%
    /*
        request.setCharacterEncoding("UTF-8");
        String no=request.getParameter("stuno");
        String name=request.getParameter("stuname");
        String classes=request.getParameter("classes");
        String gender=request.getParameter("gender");
        String department=request.getParameter("department");
        String tel=request.getParameter("tel");
        String dormo=request.getParameter("dormo");*/
    /**
     * 1.如何判断提交?
     */
    //Student student2=new Student(no,name,classes,gender,department,tel,dormo,"0");
    /**
     * 2.由于Stuno为disable，数据不能提交过来，
     * stuno在整个页面中不会发生变化，可以直接使用
     * 如果必须要提交，可以使用js在提交时修改disable为false
     */
    // StudentDao sdao=new StudentDaoImpel();
    // boolean result=sdao.updateStudent(student2);
    /**
     * 3.调用updateStudent(Student s)方法更新学生信息，
     *    如果本方法没有创建，创建它
     */

   /* if(result){
        //跳转Success
        response.sendRedirect("liststudents.jsp");
    }else {
        //跳转error
        response.sendRedirect("error.jsp");
    }*/
    /**
     * 4.根据updateStudent()返回结果，给出提示，
     *   成功，跳转到ListStudent页面
     *   失败，跳转到error页面
     */
%>
</body>
</html>
