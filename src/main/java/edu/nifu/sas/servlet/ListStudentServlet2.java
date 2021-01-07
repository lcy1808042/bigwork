package edu.nifu.sas.servlet;

import com.google.gson.Gson;
import edu.nifu.sas.dao.impl.StudentDaoImpl;
import edu.nifu.sas.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/listStudentServlet2")
public class ListStudentServlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        //1,获取学生数据
        StudentDaoImpl studentDao = new StudentDaoImpl();
        List<Student> allStudent = studentDao.getAllStudent();

        //2,把学生数据转换为json数据

        Gson gson = new Gson();
        String students = gson.toJson(allStudent);
        //3,打印
        PrintWriter out = response.getWriter();
        out.write(students);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
