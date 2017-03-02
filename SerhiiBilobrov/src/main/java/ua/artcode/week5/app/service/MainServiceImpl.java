package ua.artcode.week5.app.service;

import ua.artcode.week5.app.dao.CandidateDao;
import ua.artcode.week5.app.exception.NoRegionFoundException;
import ua.artcode.week5.app.model.Candidate;
import ua.artcode.week5.app.model.Region;

import java.util.List;

/**
 * Created by serhii on 26.02.17.
 */
public class MainServiceImpl implements MainService {

    private CandidateDao candidateDao;

    @Override
    public List<Candidate> getCandidateByRegion(Region region) throws NoRegionFoundException {
        return null;
    }

    @Override
    public List<Candidate> getCandidatesByAge(int startAge, int endAge) {
        // validation, preprocess, Logger
        return candidateDao.getByAge(startAge, endAge);
    }
}
