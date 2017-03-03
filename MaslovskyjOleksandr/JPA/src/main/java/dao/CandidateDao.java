package dao;


import exceptions.*;
import models.Candidate;
import models.Region;
import org.apache.log4j.Logger;
import utils.ManagerCreator;

import javax.persistence.EntityManager;
import javax.persistence.NamedQuery;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@NamedQuery(name="getAll", query ="SELECT * FROM candidates")
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
        return null;
    }

    @Override
    public List<Candidate> getCandidatesByRegion(Region region) throws NoRegionFoundException {
        return null;
    }

    @Override
    public List<Candidate> getCandidatesByPopularity() throws NoCandidatesFoundException {
        return null;
    }

    private EntityManager callManager(){
        LOGGER.info("GET EntityManager");
        return ManagerCreator.getManager();
    }

    private boolean makeTransactionsAction(Candidate candidate){
        EntityManager manager = callManager();

        try {
            LOGGER.info("ADD CANDIDATE TO TABLE");
            manager.getTransaction().begin();
            manager.persist(candidate);
            manager.getTransaction().commit();
            return true;
        } catch (Exception e){
            manager.getTransaction().rollback();
            return false;
        }
    }

    private List<Candidate> getALL(){
        EntityManager manager = callManager();
        Query query = manager.createNamedQuery("getAll");
        return query.getResultList();
    }
}
