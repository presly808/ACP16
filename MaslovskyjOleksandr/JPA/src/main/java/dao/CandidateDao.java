package dao;

import exceptions.*;
import models.Candidate;
import models.RegionType;
import org.apache.log4j.Logger;
import utils.ManagerCreator;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import java.util.List;

@NamedQuery(name="getAllCandidates", query ="SELECT c.id, c.name, c.age FROM candidates c")
public class CandidateDao implements DaoCandidate {

    private static final Logger LOGGER = Logger.getLogger(Candidate.class);

    @Override
    public boolean insertIntoTable(Candidate object) throws NotAvailableTableException {
        if (makeTransactionsAction(object)) {
            return true;
        }
        return false;
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
    public boolean removeCandidateById(long id) throws NoCandidatesFoundException {
        EntityManager manager = callManager();
        try {

            manager.getTransaction().begin();
            manager.remove(manager.find(Candidate.class, id));
            manager.getTransaction().commit();

            LOGGER.info("DELETE CANDIDATE FROM DB");
            return true;
        } catch (Exception e) {
            LOGGER.info("CANNOT DELETE CANDIDATE");
            e.printStackTrace();
            manager.getTransaction().rollback();
            return false;
        }
    }

    private EntityManager callManager(){
        LOGGER.info("GET EntityManager");
        return ManagerCreator.getManager();
    }

    private boolean makeTransactionsAction(Candidate candidate){
        EntityManager manager = callManager();
        try {

            manager.getTransaction().begin();
            manager.persist(candidate);
            manager.getTransaction().commit();

            LOGGER.info("ADD CANDIDATE TO TABLE");
            return true;
        } catch (Exception e){
            e.printStackTrace();
            manager.getTransaction().rollback();
            return false;
        }
    }

    private List<Candidate> getALL(){
        EntityManager manager = callManager();
        try {

            manager.getTransaction().begin();
            Query query = manager.createNamedQuery("getAllCandidates");
            List<Candidate> candidateList = query.getResultList();
            manager.getTransaction().commit();

            LOGGER.info("SHOW ALL CANDIDATES");
            return candidateList;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private List<Candidate> getCandidatesByAgeWithParam(int min, int max){
        EntityManager manager = callManager();
        try {

            manager.getTransaction().begin();
            Query query = manager.createNativeQuery("SELECT c.id, c.name, c.age FROM candidates c " +
                    "WHERE c.age between " + min + " AND " + max);
            List<Candidate> candidateList = query.getResultList();
            manager.getTransaction().commit();

            LOGGER.info("FIND CANDIDATES BY AGE");
            return candidateList;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private List<Candidate> getByRegion(RegionType region){
        EntityManager manager = callManager();
        try {

            manager.getTransaction().begin();
            List<Candidate> candidateList = manager.createNativeQuery("SELECT c.name, c.age, r.regionType " +
                    "FROM candidates c " +
                    "INNER JOIN regions r " +
                    "ON c.id = r.id " +
                    "WHERE r.regionType like '" + region + "';").getResultList();
            manager.getTransaction().commit();

            LOGGER.info("FIND CANDIDATES BY REGION");
            return candidateList;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void clearDataFromDatabase() {
        EntityManager manager = callManager();
        manager.getTransaction().begin();
        manager.createNativeQuery("DROP TABLE candidates, clans, hibernate_sequence, interests, regions");
        manager.getTransaction().commit();
    }
}
