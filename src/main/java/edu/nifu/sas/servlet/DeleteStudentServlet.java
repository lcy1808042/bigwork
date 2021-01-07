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

@WebServlet("/deleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String no=request.getParameter("stuno");
        String name=request.getParameter("stuname");
        Student student=new Student(no,name);
        StudentDao dao=new StudentDaoImpl();
        boolean result=dao.deleteStudent(student);
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
