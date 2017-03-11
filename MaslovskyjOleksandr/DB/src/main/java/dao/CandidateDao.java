package dao;

import exceptions.*;
import models.Candidate;
import models.RegionType;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class CandidateDao implements DaoCandidate {

    private static final Logger LOGGER = Logger.getLogger(Candidate.class);

    @PersistenceContext
    private EntityManager manager;

    @Override
    public void insertIntoTable(Candidate object) throws NotAvailableTableException {
        makeTransactionsAction(object);
    }

    @Override
    public Candidate getObjectFromTable(long id) throws InvalidInputObjectException {
        return null;
    }

    @Override
    public List<Candidate> showAllObjects() throws NoObjectFoundException {
        return getALL();
    }

    @Override
    public List<Candidate> getCandidatesByAge(int minAge, int maxAge) throws NoCandidatesFoundException {
        return getCandidatesByAgeWithParam(minAge, maxAge);
    }

    @Override
    public List<Candidate> getCandidatesByRegion(RegionType region) throws NoRegionFoundException {
        return getByRegion(region);
    }

    @Override
    public List<Candidate> getCandidatesByPopularity() throws NoCandidatesFoundException {
        return null;
    }

    @Override
    public void removeCandidateById(long id) throws NoCandidatesFoundException {
        Candidate candidate = manager.find(Candidate.class, id);
        manager.remove(candidate);
        LOGGER.info("DELETE CANDIDATE FROM DB");
    }

    private void makeTransactionsAction(Candidate candidate) {
        manager.persist(candidate);
        LOGGER.info("ADD CANDIDATE TO TABLE");
    }

    private List<Candidate> getALL() {

        try {
            List<Candidate> candidateList = manager.createNamedQuery
                    ("getAllCandidates", Candidate.class).getResultList();
            LOGGER.info("SHOW ALL CANDIDATES");
            return candidateList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Candidate> getCandidatesByAgeWithParam(int min, int max) {

        try {
            List<Candidate> resultList = manager.createQuery("SELECT c FROM Candidate c WHERE c.age between" +
                    " :min and :max", Candidate.class)
                    .setParameter("min", min)
                    .setParameter("max", max).getResultList();
            LOGGER.info("FIND CANDIDATES BY AGE");
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private List<Candidate> getByRegion(RegionType region) {

        try {
            List<Candidate> candidateList = manager.createQuery
                    ("select c from Candidate c join c.region r where r.regionType like :region")
                    .setParameter("region", region).getResultList();
            LOGGER.info("FIND CANDIDATES BY REGION");
            return candidateList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
