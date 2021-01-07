package edu.nifu.sas.listener;

import javax.servlet.*;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class MyAttributeListener implements ServletContextAttributeListener, HttpSessionAttributeListener, ServletRequestAttributeListener {

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
        String name = scae.getName();
        System.out.println("ServletContext添加属性:" + name + "=" + scae.getServletContext().getAttribute(name));
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
        String name = scae.getName();
        System.out.println("ServletContext移出属性:" + name);
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
        String name = scae.getName();
        System.out.println("ServletContext替换属性:" + name+"="+scae.getServletContext().getAttribute(name));
    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent se) {
        String name = se.getName();
        System.out.println("Session改变属性：" + name + "=" + se.getSession().getAttribute(name));
    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent se) {
        String name = se.getName();
        System.out.println("Session添加属性：" + name + "=" + se.getSession().getAttribute(name));
    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent se) {
        String name = se.getName();
        System.out.println("Session移出属性：" + name);
    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent srae) {

    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent srae) {

    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent srae) {

    }




}
