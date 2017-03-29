package servlet;

import com.google.gson.Gson;
import exceptions.NoCandidatesFoundException;
import models.Candidate;
import org.apache.commons.io.IOUtils;
import org.json.simple.JSONArray;
import service.ServiceCandidate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

@WebServlet(urlPatterns = {"/ajax-json"})
public class AjaxJsonServlet extends HttpServlet {

    private ServiceCandidate serviceCandidate;

    @Override
    public void init() throws ServletException {
        this.serviceCandidate = (ServiceCandidate) getServletContext().getAttribute("serviceCandidate");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/pages/ajax-json.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String data = IOUtils.toString(req.getInputStream(), "UTF-8");

        if (data.contains("allCandidates")) {
            try {
                List<Candidate> candidateList = serviceCandidate.getAllCandidates();
                sendResponse(resp, candidateList);
            } catch (NoCandidatesFoundException e) {
                e.printStackTrace();
                resp.sendError(400);
            }
        } else {
            Candidate candidate = new Gson().fromJson(data, Candidate.class);

            if (serviceCandidate.saveCandidate(candidate)) {
                sendResponse(resp, candidate);
            } else {
                resp.sendError(400, "Wrong data");
            }
        }
    }

    private void sendResponse(HttpServletResponse resp, Candidate candidate) throws IOException {
        String response = new Gson().toJson(candidate);
        resp.setContentType("text/plain");
        resp.setContentLength(response.length());
        PrintWriter out = resp.getWriter();
        out.println(response);
        out.close();
        out.flush();
    }

    private void sendResponse(HttpServletResponse resp, List<Candidate> candidate) throws IOException {
        String gsonString = new Gson().toJson(candidate);
        resp.setContentType("application/json");
        resp.setContentLength(gsonString.length());
        PrintWriter out = resp.getWriter();
        out.println(gsonString);
        out.flush();
        out.close();
    }
}
