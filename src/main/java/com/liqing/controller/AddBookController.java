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

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/WEB-INF/jsp/add.jsp");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }

    public void doPost(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        JDBCService jdbcService = new JDBCService();

        int isbn = Integer.valueOf(httpRequest.getParameter("isbn"));
        String name = httpRequest.getParameter("name");
        double price = Double.valueOf(httpRequest.getParameter("price"));
        String author = httpRequest.getParameter("author");

        jdbcService.executeUpdate("insert into book values(" + isbn + ",\"" + name + "\"," + price + ",\"" + author + "\")");

        getServletContext().getRequestDispatcher("/WEB-INF/jsp/display.jsp").forward(httpRequest, httpServletResponse);
    }

}
