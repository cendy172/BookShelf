package com.liqing.listener;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;

public class AppServletContextListener implements javax.servlet.ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("dataSource.xml");
        sce.getServletContext().setAttribute("jdbcService", classPathXmlApplicationContext.getBean("jdbcService"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().removeAttribute("jdbcService");
    }
}
