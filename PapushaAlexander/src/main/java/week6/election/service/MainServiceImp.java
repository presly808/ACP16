package week6.election.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import week6.election.dao.CandidateDao;
import week6.election.dao.RegionDao;
import week6.election.exception.NoCandidateFoundException;
import week6.election.exception.NoRegionFoundException;
import week6.election.exception.RegisterException;
import week6.election.model.Candidate;
import week6.election.model.Region;

import java.util.List;

/**
 * Created by alex on 22.03.17.
 */
@Component
public class MainServiceImp implements MainService{

    @Autowired
    private CandidateDao candidateDao;
    @Autowired
    private RegionDao regionDao;

    public MainServiceImp() {
    }

    public MainServiceImp(CandidateDao candidateDao, RegionDao regionDao) {
        this.candidateDao = candidateDao;
        this.regionDao = regionDao;
    }

    @Override
    public List<Candidate> getCandidateByAge(int lowAge, int heightAge) throws NoCandidateFoundException {
        List<Candidate> candidates = candidateDao.getByAge(lowAge, heightAge);

        if (candidates.isEmpty()){
            throw new NoCandidateFoundException("no candidates with age (" + lowAge + ", " + heightAge + ")");
        }
        return candidateDao.getByAge(lowAge, heightAge);
    }

    @Override
    public List<Candidate> getAllCandidate(int offset, int length) {
        return candidateDao.getAll(offset, length);
    }

    @Override
    public List<Candidate> getCandidateByRegion(String name) throws NoRegionFoundException{

        Region region = regionDao.findByName(name);

        if (region == null){
            throw new NoRegionFoundException("no region with name - " + name);
        }

        return candidateDao.getByRegion(region);
    }

    @Override
    public Candidate getCandidate(int id) throws NoCandidateFoundException {

        Candidate candidate = candidateDao.findOne(id);

        if (candidate == null){
            throw new NoCandidateFoundException("no candidate with id - " + id);
        }

        return candidate;
    }

    @Override
    public Candidate register(Candidate newCandidate) throws RegisterException {
        if (newCandidate == null){
            throw new RegisterException("wrong data");
        }
        return candidateDao.create(newCandidate);
    }

    public CandidateDao getCandidateDao() {
        return candidateDao;
    }

    public void setCandidateDao(CandidateDao candidateDao) {
        this.candidateDao = candidateDao;
    }

    public RegionDao getRegionDao() {
        return regionDao;
    }

    public void setRegionDao(RegionDao regionDao) {
        this.regionDao = regionDao;
    }
}
