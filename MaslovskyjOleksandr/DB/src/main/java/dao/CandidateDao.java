package dao;

import exceptions.*;
import models.Candidate;
import models.RegionType;
import org.springframework.stereotype.Component;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component(value = "candidateDao")
public class CandidateDao implements Dao {

    @PersistenceContext
    private EntityManager manager;

    public CandidateDao() {
    }

    @Override
    public void insertIntoTable(Candidate candidate) throws NotAvailableTableException {
        manager.persist(candidate);
    }

    @Override
    public Candidate getCandidateFromDb(long id) throws InvalidInputObjectException {
        return manager.find(Candidate.class, id);
    }

    @Override
    public Candidate dropCandidate(long id) throws InvalidInputObjectException {
        Candidate candidate = getCandidateFromDb(id);
        manager.remove(candidate);
        return candidate;
    }

    @Override
    public List<Candidate> getAllObjects() throws NoCandidatesFoundException {
        try {
            List<Candidate> candidateList = manager.createNamedQuery
                    ("getAllCandidates", Candidate.class).getResultList();
            return candidateList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Candidate> getAllByAgeParam(int min, int max) throws NoCandidatesFoundException {
        try {
            List<Candidate> resultList = manager.createQuery("SELECT c FROM Candidate c WHERE c.age between" +
                    " :min and :max", Candidate.class)
                    .setParameter("min", min)
                    .setParameter("max", max).getResultList();
            return resultList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Candidate> getCandidateByRegionParam(RegionType region) throws NoCandidatesFoundException {
        try {
            List<Candidate> candidateList = manager.createQuery
                    ("select c from Candidate c join c.region r where r.regionType like :region")
                    .setParameter("region", region).getResultList();
            return candidateList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }
}
