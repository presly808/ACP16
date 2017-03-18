package listener;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.ServiceCandidate;
import service.ServiceCandidateImp;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class InitServiceCandidate implements ServletContextListener{

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring.xml");
        ServiceCandidate serviceCandidate = applicationContext.getBean(ServiceCandidate.class);
        sce.getServletContext().setAttribute("serviceCandidate", serviceCandidate);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        sce.getServletContext().removeAttribute("serviceCandidate");
    }
}
