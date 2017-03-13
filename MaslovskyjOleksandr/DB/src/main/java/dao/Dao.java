package dao;


import exceptions.InvalidInputObjectException;
import exceptions.NoCandidatesFoundException;
import exceptions.NoObjectFoundException;
import exceptions.NotAvailableTableException;
import models.Candidate;
import models.RegionType;

import java.util.List;

public interface Dao{

    void insertIntoTable(Candidate candidate) throws NotAvailableTableException;

    Candidate getCandidateFromDb(long id) throws InvalidInputObjectException;

    Candidate dropCandidate(long id) throws InvalidInputObjectException;

    List<Candidate> getAllObjects() throws NoCandidatesFoundException;

    List<Candidate> getAllByAgeParam(int min, int max) throws NoCandidatesFoundException;

    List<Candidate> getCandidateByRegionParam(RegionType region) throws NoCandidatesFoundException;

    void dropAllCandidateData();

    void dropAllClanData();

    void dropAllInterestsData();

    void dropAllRegionsData();
}
