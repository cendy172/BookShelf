package com.liqing.listener;

import com.liqing.dto.JDBCService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.ServletContextEvent;

public class AppServletContextListener implements javax.servlet.ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("dataSource.xml");
        sce.getServletContext().setAttribute("jdbcService", classPathXmlApplicationContext.getBean("jdbcService"));
        sce.getServletContext().setAttribute("addBookService", classPathXmlApplicationContext.getBean("addBookService"));
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ((JDBCService) sce.getServletContext().getAttribute("jdbcService")).closeConnection();
        sce.getServletContext().removeAttribute("jdbcService");
        sce.getServletContext().removeAttribute("addBookService");
    }
}
