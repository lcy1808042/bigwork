package edu.nifu.sas.servlet;

import edu.nifu.sas.dao.impl.StudentDaoImpl;
import edu.nifu.sas.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listStudentServlet")
public class ListStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //1,获取学生数据
        StudentDaoImpl studentDao = new StudentDaoImpl();
        List<Student> allStudent = studentDao.getAllStudent();
        //2,把学生数据保存到request
        //去耦，服务器把数据存放到request，不关心客户端如何处理
        request.setAttribute("students",allStudent);
        //3,跳转到listStudent页面
        request.getRequestDispatcher("listStudentsByPaging.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
