package edu.nifu.sas.servlet;

import edu.nifu.sas.dao.StudentDao;
import edu.nifu.sas.dao.impl.StudentDaoImpl;
import edu.nifu.sas.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateUserInfoServlet")
public class UpdateUserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1,获取学生与用户信息
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String no=request.getParameter("stuno");
        String name=request.getParameter("stuname");
        String classes=request.getParameter("classes");
        String gender=request.getParameter("gender");
        String department=request.getParameter("department");
        String tel=request.getParameter("tel");
        String dormo=request.getParameter("dormo");
        //2，创建学生表
        Student student = new Student(no,name,classes,gender,department,tel,dormo,"0");
        //3，更新用户信息
        StudentDao dao=new StudentDaoImpl();
        boolean result = dao.updateStudent(student);

        //4，保存学生信息
        //5，输出，成功或失败
        if(result){
            System.out.println("success");
            response.sendRedirect("success.jsp");
        }else{
            System.out.println("fail");
            response.sendRedirect("error.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
