package week5.election.dao;

/**
 * Created by alex on 03.03.17.
 */

import week5.election.model.Candidate;

import java.util.List;

/**
 * crud - create, read, update, delete + specific methods
 */
public interface CandidateDao extends Dao<Candidate,Integer> {

    List<Candidate> getByAge(int lowAge, int heightAge);

}
