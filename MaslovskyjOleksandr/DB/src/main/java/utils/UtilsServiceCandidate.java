package utils;

import exceptions.NoCandidatesFoundException;
import models.Candidate;

import java.util.List;


public interface UtilsServiceCandidate {

    void deleteAllCandidates();

    void deleteAllClans();

    void deleteAllRegions();

    void deleteAllInterests();

    List<Candidate> getAllCandidates() throws NoCandidatesFoundException;

}
