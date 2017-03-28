package week6.election.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import week6.election.model.Candidate;
import week6.election.service.MainServiceImp;

import java.util.List;

/**
 * Created by alex on 24.03.17.
 */
public class TestSpring {
    public static void main(String[] args) {
        ApplicationContext context =
                new ClassPathXmlApplicationContext("week6/app-context.xml");
        MainServiceImp service = context.getBean(MainServiceImp.class);
        List<Candidate> candidates = service.getAllCandidate(0,2);

        candidates.stream().forEach(System.out::println);
    }
}
