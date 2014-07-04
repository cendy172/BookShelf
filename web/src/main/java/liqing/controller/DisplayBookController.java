package liqing.controller;

import com.liqing.domain.Book;
import com.liqing.service.DisplayBookService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DisplayBookController extends HttpServlet {
    private DisplayBookService displayBookService;

    @Override
    public void init() throws ServletException {
        super.init();
        displayBookService = (DisplayBookService) getServletConfig().getServletContext().getAttribute("displayBookService");
    }

    public void doGet(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
        List<Book> books = displayBookService.getAllBooks();

        httpServletRequest.setAttribute("books", books);
        RequestDispatcher requestDispatcher = httpServletRequest.getRequestDispatcher("/WEB-INF/jsp/display.jsp");
        requestDispatcher.forward(httpServletRequest, httpServletResponse);
    }
}
