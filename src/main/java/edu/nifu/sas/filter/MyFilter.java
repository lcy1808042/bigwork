package edu.nifu.sas.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

//@WebFilter(urlPatterns = "/MyFilter")
public class MyFilter  implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String encoding=filterConfig.getInitParameter("encoding");
        String namespace = filterConfig.getInitParameter("namespace");

        System.out.println("MyFilter.init()方法被调用");
        System.out.println("------------"+encoding+"------------"+namespace+"-------------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        //System.out.println("MyFilter.doFilter()方法开始工作");
        //检查用户是否已经登录，如果没有登录，跳转到登录界面
        //1,如何判断用户是否已经登录？session.getAttribute("user")是否存在
        //如果存在则认为已经登录
        //用户已经登录，不做任何处理
        HttpSession session = ((HttpServletRequest) servletRequest).getSession();
        Object user = session.getAttribute("user");
        if(user==null){
            PrintWriter writer = ((HttpServletResponse) servletResponse).getWriter();
            writer.write("<script> alert('用户未登录，请登录后访问！');location.href='index.html'</script>");
        }else {
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {
        System.out.println("MyFilter.destroy()被调用");
    }
}
