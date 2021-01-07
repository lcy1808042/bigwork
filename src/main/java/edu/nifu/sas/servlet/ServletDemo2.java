package edu.nifu.sas.servlet;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletDemo2 extends GenericServlet {
    // GenericServlet这是一个抽象类
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("GenericServlet is serving!");
        PrintWriter out = servletResponse.getWriter();
        out.write("hello world");
    }
}
