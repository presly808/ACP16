package week5.election.service;

import week5.election.exception.NoRegionFoundException;
import week5.election.model.Candidate;
import week5.election.model.Clan;
import week5.election.model.Region;

import java.util.List;

/**
 * Created by alex on 03.03.17.
 */
public interface MainService {

    List<Candidate> getCandidateByRegion(Region region) throws NoRegionFoundException;

    List<Candidate> getCandidatesByAge(int startAge, int endAge);

    Clan createClan(Clan entity);

}