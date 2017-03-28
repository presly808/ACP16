package ua.artcode.week8.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 * Created by alex on 25.03.17.
 */

public class HelloServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userNameParametr = req.getParameter("name");
        String queryString = req.getQueryString();

        System.out.printf("client %s, name %s, query %s", req.getRemoteUser(), userNameParametr, queryString);
        Cookie[] cookies = req.getCookies();

        if (cookies != null) {
            Arrays.stream(cookies).forEach((cookie ->
                    System.out.printf("name %s, value %s", cookie.getName(), cookie.getValue())));
        }
        PrintWriter pw = resp.getWriter();
        pw.printf("<h1>Hello %s</h1>", userNameParametr);
        pw.flush();
    }

}
