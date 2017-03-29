package week6.election.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import week6.election.entityManager.Manager;
import week6.election.exception.NoCandidateFoundException;
import week6.election.model.Candidate;
import week6.election.service.MainServiceImp;

import java.util.List;

/**
 * Created by alex on 21.03.17.
 */
public class TestMethod {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("app-context.xml");
        MainServiceImp service = (MainServiceImp) context.getBean("service");
        Manager manager = (Manager) context.getBean("manager");

        //List<Candidate> candidates = service.getAllCandidate(2,3, manager);
        //List<Candidate> candidates = service.getCandidateByAge(40, 50, manager);
        //List<Candidate> candidates = service.getCandidateByRegion("Kiev");

        try {
            List<Candidate> candidates = service.getCandidateByAge(30, 31);
            candidates.stream().forEach(System.out::println);
        } catch (NoCandidateFoundException e) {
            e.printStackTrace();
        }



        manager.getEntityManagerFactory().close();


    }
}
