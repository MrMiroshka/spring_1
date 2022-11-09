package ru.geekbrains.hw1.servlets;

import ru.geekbrains.hw1.Product;
import ru.geekbrains.hw1.modProducts;
import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FirstServlet extends HttpServlet {
   // private static Logger logger = LoggerFactory.getLogger(FirstServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");
        resp.getWriter().printf("<html><body>");
        //делаем магию с продуктами
        for (int i = 1; i < 11; i++) {
            Product pr = modProducts.generateProduct();
            resp.getWriter().printf("<h1> Продукт" + i + ": </h1>");
            resp.getWriter().printf("<h2> id = " + pr.getId() + "</h2>");
            resp.getWriter().printf("<h2> cost = " + pr.getCost() + "</h2>");
            resp.getWriter().printf("<h2> title = " + pr.getTitle() + "</h2>");
        }
        resp.getWriter().printf("</body></html>");

    }

    @Override
    public void init() throws ServletException {
      //  logger.debug("Init");
    }
}
