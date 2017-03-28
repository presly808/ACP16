package week5.election;

import week5.election.dao.RegionDao;
import week5.election.model.Region;

import java.util.List;

/**
 * Created by alex on 04.03.17.
 */
public class Test {
    public static void main(String[] args) {
        /*List<Candidate> candidates;
        MainService mainService = new MainServiceImpl();
        candidates = mainService.getCandidatesByAge(40, 50);
        candidates.stream().forEach(System.out::println);*/

        List<Region> regions = new RegionDao().getAll(0,0);

        regions.stream().forEach(System.out::println);

    }
}
