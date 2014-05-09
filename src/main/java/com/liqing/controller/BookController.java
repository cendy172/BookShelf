package com.liqing.controller;

import com.liqing.domain.Book;
import com.liqing.dto.JDBCService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookController extends HttpServlet {

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        JDBCService jdbcService = new JDBCService();
        ArrayList<Book> books = new ArrayList<Book>();

        ResultSet result = jdbcService.execute("select * from book");
        try {
            while (result.next()) {
                Book book = new Book();
                book.setIsbn(result.getInt("1"));
                book.setName(result.getString("2"));
                book.setPrice(result.getDouble("3"));
                book.setAuthor(result.getString("4"));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        httpServletRequest.setAttribute("books", books);
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/WEB-INF/jsp/display.jsp");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }

    public void doPost(HttpServletRequest httpRequest, HttpServletResponse httpServletResponse) {
        JDBCService jdbcService = new JDBCService();
        jdbcService.execute("select * from book");
    }

}
