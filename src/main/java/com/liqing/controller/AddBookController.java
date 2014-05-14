package com.liqing.controller;

import com.liqing.dto.JDBCService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddBookController extends HttpServlet {


    private JDBCService jdbcService;

    @Override
    public void init() throws ServletException {
        super.init();
        jdbcService = (JDBCService) getServletConfig().getServletContext().getAttribute("jdbcService");
        if (jdbcService == null) {
            jdbcService = new JDBCService();
            getServletConfig().getServletContext().setAttribute("jdbcService", jdbcService);
        }
    }

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/WEB-INF/jsp/add.jsp");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }

    public void doPost(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        int isbn = Integer.valueOf(httpRequest.getParameter("isbn"));
        String name = httpRequest.getParameter("name");
        double price = Double.valueOf(httpRequest.getParameter("price"));
        String author = httpRequest.getParameter("author");

        jdbcService.executeUpdate("insert into book values(" + isbn + ",\"" + name + "\"," + price + ",\"" + author + "\")");
        httpServletResponse.sendRedirect("display");
    }

}
