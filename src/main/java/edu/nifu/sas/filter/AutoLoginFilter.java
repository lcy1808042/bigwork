package edu.nifu.sas.filter;

import edu.nifu.sas.dao.UserDao;
import edu.nifu.sas.model.User;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class AutoLoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        //1，获取cookie,是保存在client端的键值对，多个键值对组成数组
        Cookie[] cookies=request.getCookies();
        //2，在cookie中查找key：autologin,把值保存
        String autoLogin=null;
        for(Cookie c:cookies){
            if(c.getName().equalsIgnoreCase("autoLogin")){
                autoLogin=c.getValue();
            }
        }
        //3,判断是否为null,null表示cookie中没有找到
        if(autoLogin!=null){
            //自动登录
            //把真正的用户名与密码表示为："zhangsan-123456"
            String[] users = autoLogin.split("-");

            User u=new User(users[0],users[1]);
            boolean result = new UserDao().checkLogin(u);
            if(result){
                //登录成功，把用户信息放入session中
                request.getSession().setAttribute("user",u);
            }
        }
        //放行所有请求
        filterChain.doFilter(request,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
