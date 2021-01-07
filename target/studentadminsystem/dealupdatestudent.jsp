<%@ page import="edu.nifu.sas.model.Student" %>
<%@ page import="edu.nifu.sas.dao.StudentDao" %>
<%@ page import="edu.nifu.sas.dao.impl.StudentDaoImpl" %><%--
  Created by IntelliJ IDEA.
  User: xy
  Date: 2020/12/23
  Time: 19:16
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
     * 1.如何判断提交?
     */
    Student student2=new Student(no,name,classes,gender,department,tel,dormo,"0");

    String t=student2.getStuNo();
    out.print(t);
    /**
     * 2.由于Stuno为disable，数据不能提交过来，
     * stuno在整个页面中不会发生变化，可以直接使用
     * 如果必须要提交，可以使用js在提交时修改disable为false
     */
    StudentDao sdao=new StudentDaoImpl();
    boolean result=sdao.updateStudent(student2);
    /**
     * 3.调用updateStudent(Student s)方法更新学生信息，
     *    如果本方法没有创建，创建它
     */

    /*if(result){
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