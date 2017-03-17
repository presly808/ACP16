package utils;

import dao.Dao;
import exceptions.NoCandidatesFoundException;
import models.Candidate;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UtilsServiceCandidateImp implements UtilsServiceCandidate {

    private final static Logger LOGGER = Logger.getLogger(UtilsServiceCandidate.class);

    @Autowired
    private Dao dao;

    public UtilsServiceCandidateImp() {
    }

    @Override
    public void deleteAllCandidates() {
        LOGGER.info("deleteAllCandidates");
        dao.dropAllCandidateData();
    }

    @Override
    public void deleteAllClans() {
        LOGGER.info("deleteAllClans");
        dao.dropAllClanData();
    }

    @Override
    public void deleteAllRegions() {
        LOGGER.info("deleteAllRegions");
        dao.dropAllRegionsData();
    }

    @Override
    public void deleteAllInterests() {
        LOGGER.info("deleteAllInterests");
        dao.dropAllInterestsData();
    }

    @Override
    public List<Candidate> getAllCandidates() throws NoCandidatesFoundException {
        LOGGER.info("getAllCandidates");
        return dao.getAllObjects();
    }

    public Dao getDao() {
        return dao;
    }

    public void setDao(Dao dao) {
        this.dao = dao;
    }
}
