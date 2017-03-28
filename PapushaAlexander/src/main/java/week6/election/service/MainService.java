package week6.election.service;

import week6.election.exception.NoCandidateFoundException;
import week6.election.exception.NoRegionFoundException;
import week6.election.exception.RegisterException;
import week6.election.model.Candidate;

import java.util.List;

/**
 * Created by alex on 22.03.17.
 */
public interface MainService {

    List<Candidate> getCandidateByAge(int lowAge, int heightAge) throws NoCandidateFoundException;
    List<Candidate> getAllCandidate(int offset, int length);
    List<Candidate> getCandidateByRegion(String name) throws NoRegionFoundException;
    Candidate getCandidate(int id) throws NoCandidateFoundException;
    Candidate register(Candidate newCandidate) throws RegisterException;
}
