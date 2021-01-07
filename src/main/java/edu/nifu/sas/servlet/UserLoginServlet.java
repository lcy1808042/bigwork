package edu.nifu.sas.servlet;

import edu.nifu.sas.dao.UserDao;
import edu.nifu.sas.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1,获取用户名与密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = new User(username, password);
        boolean result = new UserDao().checkLogin(user);

        //2，验证
        if(result){
            //3，成功后把用户名密码保存到session，中
            request.getSession().setAttribute("user",user);
            //4，创建cookie，设置保存路径，发送client端
            String autologin = request.getParameter("autologin");
            if(autologin!=null){
                Cookie cookie = new Cookie("autologin", username + "-" + password);
                //设置cookie的年龄最大存活期
                cookie.setMaxAge(Integer.parseInt(autologin));
                //设置cookie路径
                cookie.setPath(request.getContextPath());
                response.addCookie(cookie);
            }
            //跳转到首页,或其他页面,三种方式
            response.sendRedirect("listStudentsByPaging.jsp");

        }else {
            //跳转到登录页面
            response.sendRedirect("index.html");

        }

    }
}
