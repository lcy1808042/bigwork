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

@WebServlet("/saveStudentServlet")
public class SaveStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //使用doPost方式处理保存学生请求
        //1,获取学生信息
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        String no=request.getParameter("stuno");
        String name=request.getParameter("stuname");
        String classes=request.getParameter("classes");
        String gender=request.getParameter("gender");
        String department=request.getParameter("department");
        String tel=request.getParameter("tel");
        String dormo=request.getParameter("dormo");
        String photopath;
        if(gender=="男"){
            photopath="images/boy.jpeg";
        }else {
            photopath="images/girl.jpeg";
        }
        //2，创建学生对象
        Student student = new Student(no,name,classes,gender,department,tel,dormo,photopath);


        //3，调用studentDao方法

        StudentDao dao=new StudentDaoImpl();
        boolean result = dao.saveStudent(student);

        //4，根据返回结果进行页面跳转
        if(result){
            System.out.println("success");
            response.sendRedirect("success.jsp");
        }else{
            System.out.println("fail");
            response.sendRedirect("error.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }
}
