package com.example.mybook.listener;

import com.example.mybook.Biz.TypeBiz;
import com.example.mybook.bean.Type;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.List;

@WebListener
public class TypeServletContextListener implements ServletContextListener, ServletContextAttributeListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent){
        TypeBiz biz=new TypeBiz();
        List<Type> types=biz.getAll();
        ServletContext application=servletContextEvent.getServletContext();
        application.setAttribute("types",types);
    }
}
