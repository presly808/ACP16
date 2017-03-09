package dao;

import exceptions.*;
import models.Candidate;
import models.RegionType;
import org.apache.log4j.Logger;
import java.util.List;

public class CandidateDao implements DaoCandidate {

    private static final Logger LOGGER = Logger.getLogger(Candidate.class);

    @Override
    public void insertIntoTable(Candidate object) throws NotAvailableTableException {

    }

    @Override
    public Candidate getObjectFromTable(long id) throws InvalidInputObjectException {
        return null;
    }

    @Override
    public List<Candidate> showAllObjects() throws NoObjectFoundException {
        return null;
    }

    @Override
    public List<Candidate> getCandidatesByAge(int minAge, int maxAge) throws NoCandidatesFoundException {
        return null;
    }

    @Override
    public List<Candidate> getCandidatesByRegion(RegionType region) throws NoRegionFoundException {
        return null;
    }

    @Override
    public List<Candidate> getCandidatesByPopularity() throws NoCandidatesFoundException {
        return null;
    }

    @Override
    public void removeCandidateById(long id) throws NoCandidatesFoundException {

    }
}
