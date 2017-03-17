package listener;


import service.ServiceCandidate;
import service.ServiceCandidateImp;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitServiceCandidate implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServiceCandidate serviceCandidate = new ServiceCandidateImp();
        sce.getServletContext().setAttribute("serviceCandidate", serviceCandidate);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().removeAttribute("serviceCandidate");
    }
}
