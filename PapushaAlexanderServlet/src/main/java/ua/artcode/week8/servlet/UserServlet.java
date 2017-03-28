package ua.artcode.week8.servlet;

import ua.artcode.week8.model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //validation
        //get request data

        req.setAttribute("user", new User(1, "Oleg", 2500));
        req.getRequestDispatcher("/WEB-INF/pages/user-info.jsp").forward(req, resp);

    }
}
