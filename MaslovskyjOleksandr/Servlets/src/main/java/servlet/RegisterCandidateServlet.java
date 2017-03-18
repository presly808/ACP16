package servlet;

import models.*;
import service.ServiceCandidate;
import utils.CandidateValidation;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = {"/register"})
public class RegisterCandidateServlet extends HttpServlet {

    private ServiceCandidate serviceCandidate;

    @Override
    public void init() throws ServletException {
        serviceCandidate = (ServiceCandidate) getServletContext().getAttribute("serviceCandidate");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/candidateRegistration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        if (req.getParameter("name").isEmpty()) {
            req.getRequestDispatcher("/pages/error.jsp").forward(req, resp);
        }
        String name = name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        String clan = req.getParameter("clan");
        String region = req.getParameter("region");
        String interests = req.getParameter("interests");

        Candidate candidate = new Candidate(name, age, new Clan(clan),
                new Region(RegionType.REGION_1), new Interest(InterestsType.FINANCE));

        if (serviceCandidate.saveCandidate(candidate)) {
            req.setAttribute("candidate", candidate);
            req.getRequestDispatcher("/pages/candidate-info.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/pages/error.jsp").forward(req, resp);
        }

    }
}
