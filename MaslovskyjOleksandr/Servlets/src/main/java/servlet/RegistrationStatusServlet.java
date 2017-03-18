package servlet;

import exceptions.NoCandidatesFoundException;
import models.Candidate;
import org.apache.log4j.Logger;
import service.ServiceCandidate;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = {"/status"})
public class RegistrationStatusServlet extends HttpServlet{

    private static final Logger LOGGER = Logger.getLogger(RegistrationStatusServlet.class);

    private ServiceCandidate serviceCandidate;

    @Override
    public void init(ServletConfig config) throws ServletException {
        serviceCandidate = (ServiceCandidate) getServletContext().getAttribute("serviceCandidate");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Candidate> candidateList = serviceCandidate.getAllCandidates();
            req.setAttribute("candidates", candidateList );
        } catch (NoCandidatesFoundException e) {
            LOGGER.error(e);
        }
        req.getRequestDispatcher("/pages/electionInfo").forward(req, resp);
    }

}
