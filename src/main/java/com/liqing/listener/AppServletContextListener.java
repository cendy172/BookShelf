package com.liqing.listener;

import com.liqing.dto.JDBCService;

import javax.servlet.ServletContextEvent;

public class AppServletContextListener implements javax.servlet.ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("jdbcService", new JDBCService());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
