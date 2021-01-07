package edu.nifu.sas.servlet;

import com.google.gson.Gson;
import edu.nifu.sas.dao.UserDao;
import edu.nifu.sas.model.User;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

//@WebServlet("/loginServlet")
@WebServlet("/userLogin")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");


        PrintWriter writer = response.getWriter();
        Map map=new HashMap();
        //1,获取值（用户输入）
        String userName=request.getParameter("username");
        String password=request.getParameter("password");
        if(userName!=null&&password!=null) {

            //2，创建对象
            User u=new User(userName,password);
            //3，验证密码
            UserDao userDao=new UserDao();
            boolean result=userDao.checkLogin(u);
            if(result){
                //验证成功
                map.put("result","ok");
                map.put("mag","登陆成功");
            }else{
                map.put("result","false");
                map.put("mag","登陆失败");
            }

        }else {
            map.put("result","false");
            map.put("mag","登陆失败");
        }
        //4，输出
        writer.write(new Gson().toJson(map));

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request,response);
    }
}
