package week5.election.service;

import week5.election.dao.CandidateDao;
import week5.election.dao.CandidateDaoImpl;
import week5.election.dao.ClanDao;
import week5.election.dao.Dao;
import week5.election.exception.NoRegionFoundException;
import week5.election.model.Candidate;
import week5.election.model.Clan;
import week5.election.model.Region;

import java.util.List;

/**
 * Created by alex on 03.03.17.
 */
public class MainServiceImpl implements MainService {

    private CandidateDao candidateDao = new CandidateDaoImpl();
    private Dao clanDao = new ClanDao();

    @Override
    public List<Candidate> getCandidateByRegion(Region region) throws NoRegionFoundException {
        return null;
    }

    @Override
    public List<Candidate> getCandidatesByAge(int startAge, int endAge) {
        // validation, preprocess, Logger
        return candidateDao.getByAge(startAge, endAge);
    }

    @Override
    public Clan createClan(Clan entity) {
        return (Clan)clanDao.create(entity);
    }
}
