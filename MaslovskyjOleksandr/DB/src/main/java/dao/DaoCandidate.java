package dao;

import exceptions.NoCandidatesFoundException;
import exceptions.NoRegionFoundException;
import models.Candidate;
import models.RegionType;

import java.util.List;

public interface DaoCandidate extends Dao<Candidate>{

    List<Candidate> getCandidatesByAge(int minAge, int maxAge) throws NoCandidatesFoundException;

    List<Candidate> getCandidatesByRegion(RegionType region) throws NoRegionFoundException;

    List<Candidate> getCandidatesByPopularity() throws NoCandidatesFoundException;

    void removeCandidateById(long id) throws NoCandidatesFoundException;
}
