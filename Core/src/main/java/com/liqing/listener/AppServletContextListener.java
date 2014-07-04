package com.liqing.listener;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;

public class AppServletContextListener implements javax.servlet.ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        sce.getServletContext().setAttribute("addBookService", classPathXmlApplicationContext.getBean("addBookService"));
        sce.getServletContext().setAttribute("displayBookService", classPathXmlApplicationContext.getBean("displayBookService"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().removeAttribute("addBookService");
        sce.getServletContext().removeAttribute("displayBookService");
    }
}
