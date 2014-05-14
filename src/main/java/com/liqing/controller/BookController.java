package com.liqing.controller;

import com.liqing.domain.Book;
import com.liqing.dto.JDBCService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BookController extends HttpServlet {

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
        ArrayList<Book> books = new ArrayList<Book>();
        ResultSet result = jdbcService.executeSelect("select * from book");
        try {
            while (result.next()) {
                Book book = new Book();
                book.setIsbn(result.getInt(1));
                book.setName(result.getString(2));
                book.setPrice(result.getDouble(3));
                book.setAuthor(result.getString(4));
                books.add(book);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        httpServletRequest.setAttribute("books", books);
        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/display.jsp");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }
}
