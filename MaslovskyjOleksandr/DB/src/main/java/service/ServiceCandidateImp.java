package service;

import dao.Dao;
import exceptions.InvalidInputObjectException;
import exceptions.NoCandidatesFoundException;
import exceptions.NoRegionFoundException;
import exceptions.NotAvailableTableException;
import models.Candidate;
import models.RegionType;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service(value = "serviceCandidate")
@Transactional
public class ServiceCandidateImp implements ServiceCandidate {

    private final static Logger LOGGER = Logger.getLogger(ServiceCandidate.class);

    private Dao dao;

    @Autowired
    public ServiceCandidateImp(Dao dao) {
        this.dao = dao;
    }

    public ServiceCandidateImp() {
    }

    @Override
    public boolean saveCandidate(Candidate candidate) {
        try {
            dao.insertIntoTable(candidate);
            LOGGER.info("SAVE CANDIDATE INTO DB");
            return true;
        } catch (NotAvailableTableException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteCandidate(long id) throws NoCandidatesFoundException {
        try {
            dao.dropCandidate(id);
            LOGGER.info("CANDIDATE DELETED FROM DB");
            return true;
        } catch (InvalidInputObjectException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Candidate> getCandidatesByAge(int minAge, int maxAge) throws NoCandidatesFoundException {
        LOGGER.info("SHOW CANDIDATE BY AGE");
        return dao.getAllByAgeParam(minAge, maxAge);
    }

    @Override
    public List<Candidate> getCandidatesByRegion(RegionType region) throws NoRegionFoundException, NoCandidatesFoundException {
        LOGGER.info("SHOW CANDIDATE BY REGION");
        return dao.getCandidateByRegionParam(region);
    }

    @Override
    public List<Candidate> getAllCandidates() throws NoCandidatesFoundException {
        LOGGER.info("SHOW ALL CANDIDATES");
        return dao.getAllObjects();
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }
}
