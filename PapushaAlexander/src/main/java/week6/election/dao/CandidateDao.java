package week6.election.dao;

import week6.election.model.Candidate;
import week6.election.model.Region;

import java.util.List;

/**
 * Created by alex on 22.03.17.
 */
public interface CandidateDao extends Dao<Candidate, Integer> {

    List<Candidate> getByAge(int lowAge, int heightAge);
    List<Candidate> getByRegion(Region region);

}
