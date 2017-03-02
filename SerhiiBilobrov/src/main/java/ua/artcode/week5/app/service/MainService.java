package ua.artcode.week5.app.service;

import ua.artcode.week5.app.exception.NoRegionFoundException;
import ua.artcode.week5.app.model.Candidate;
import ua.artcode.week5.app.model.Region;

import java.util.List;

/**
 * Created by serhii on 26.02.17.
 */
public interface MainService {


    List<Candidate> getCandidateByRegion(Region region) throws NoRegionFoundException;

    List<Candidate> getCandidatesByAge(int startAge, int endAge);

}
