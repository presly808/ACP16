package week6.election.servlet;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import week6.election.exception.RegisterException;
import week6.election.model.Candidate;
import week6.election.service.MainService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by alex on 28.03.17.
 */
@WebServlet(urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(RegisterServlet.class);

    private ApplicationContext applicationContext;
    private MainService mainService;

    @Override
    public void init() throws ServletException {
        applicationContext = (ApplicationContext) getServletContext().getAttribute("app-context");
        mainService = applicationContext.getBean(MainService.class);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String ageStr = request.getParameter("age");

        if (name == null || ageStr == null){
            //redirect
            response.sendRedirect("http/error.jsp");
            // current localhost:8080/election/register
            // Absolute path = /http/error.jsp localhost:8080/http/error
            // Relative path = http/error.jsp localhost:8080/election/http/error.jsp
        } else {
            Integer age = Integer.parseInt(ageStr);
            Candidate candidate = new Candidate(name, age);

            try {
                Candidate created = mainService.register(candidate);
                request.setAttribute("candidate", created);
                request.getRequestDispatcher("/WEB-INF/pages/candidate-info.jsp").forward(request, response);
            } catch (RegisterException e) {
                LOG.error(e);
                // forward to a error page
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/register.jsp").forward(request, response);
    }
}
