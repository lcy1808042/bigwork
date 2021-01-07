package edu.nifu.sas.servlet;

import javax.jws.WebParam;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet("/servletConfigDemoServlet")

@WebServlet(urlPatterns = "/servletConfigDemoServlet",
        initParams = {@WebInitParam(name="pageSize",value="10"),
                @WebInitParam(name="encoding",value = "utf-8")
        }
)
public class ServletConfigDemoServlet extends HttpServlet {
    private Integer pageSize;
    private String encoding;
    private ServletContext application;
    @Override
    public void init(ServletConfig config) throws ServletException {
        application = config.getServletContext();

        pageSize = Integer.parseInt(config.getInitParameter("pageSize"));
        encoding = config.getInitParameter("encoding");

//        pageSize = Integer.parseInt(application.getInitParameter("pageSize"));
//        encoding = application.getInitParameter("encoding");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

          response.getWriter().write(pageSize+" "+encoding);
//        application.setAttribute("classname","software engine 18!");
//        response.sendRedirect("/anotherServlet");
    }
    /*
    * 1，servletConfig获取web，xml，servlet初始化数据，获取servlet信息，可以把需要初始化的数据放到web.xml文件
    * 2,servletContext
    *   相当于web application，全局的，从网站开始运行，到网站介绍，一直有效
    *    配置一些参数，对整个网站都是有效的（如分页编码）
    *    获取网站信息
    * */
}
