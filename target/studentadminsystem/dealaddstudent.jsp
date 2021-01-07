<%@ page import="edu.nifu.sas.model.Student" %>
<%@ page import="edu.nifu.sas.dao.StudentDao" %>
<%@ page import="edu.nifu.sas.dao.impl.StudentDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: xy
  Date: 2020/12/23
  Time: 18:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    request.setCharacterEncoding("UTF-8");
    String no=request.getParameter("stuno");
    String name=request.getParameter("stuname");
    String classes=request.getParameter("classes");
    String gender=request.getParameter("gender");
    String department=request.getParameter("department");
    String tel=request.getParameter("tel");
    String dormo=request.getParameter("dormo");
    /**
     * 1.获取学生信息
     */

    Student student=new Student(no,name,classes,gender,department,tel,dormo,"0");
    // String t=student.getGender();
    // out.print(t);
    /**
     * 2.根据学生信息生成Student对象
     */
    StudentDao sdao=new StudentDaoImpl();
    boolean result=sdao.saveStudent(student);
    /**
     * 3.调用StudentDao对象保存学生对象到数据库中
     */
   /* if(result){
        //跳转Success
        response.sendRedirect("liststudents.jsp");
    }else {
        //跳转error
        response.sendRedirect("error.jsp");
    }*/
    /**
     * 4.根据保存结果，进行页面跳转
     * true，跳转到liststudents页面
     * false，跳转到错误页面
     */

%>
