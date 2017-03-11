package service;

import exceptions.NoCandidatesFoundException;
import exceptions.NoRegionFoundException;
import models.Candidate;
import models.RegionType;

import java.util.List;

public interface ServiceCandidate {

    boolean saveCandidate(Candidate candidate);

    boolean deleteCandidate(long id) throws NoCandidatesFoundException;

    List<Candidate> getCandidatesByAge(int minAge, int maxAge) throws NoCandidatesFoundException;

    List<Candidate> getCandidatesByRegion(RegionType region) throws NoRegionFoundException, NoCandidatesFoundException;

    List<Candidate> getAllCandidates() throws NoCandidatesFoundException;
}
