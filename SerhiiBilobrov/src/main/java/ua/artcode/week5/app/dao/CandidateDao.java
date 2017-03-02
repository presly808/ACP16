package ua.artcode.week5.app.dao;

import ua.artcode.week5.app.model.Candidate;

import java.util.List;

/**
 * crud - create, read, update, delete + specific methods
 */
public interface CandidateDao extends Dao<Candidate,Integer> {

    List<Candidate> getByAge(int lowAge, int hightAge);

}
