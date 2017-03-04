package dao;

import models.Candidate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.DbOperationFactory;
import static utils.GenerateData.*;

import java.util.List;

public class CandidateDaoTest {

    private int minAge;
    private int maxAge;
    private Candidate candidate;

    @Before
    public void dataPreparation(){
        minAge = 20;
        maxAge = 50;
        this.candidate = generateCandidate();
    }

    @Test
    public void insertIntoTable() throws Exception {
        boolean actual = DbOperationFactory.newInstance().createDaoCandidate().insertIntoTable(candidate);
        Assert.assertTrue(actual);
    }

    @Test
    public void getCandidatesByAge() throws Exception {
        List<Candidate> candidates = DbOperationFactory.newInstance().createDaoCandidate().getCandidatesByAge(minAge, maxAge);
        Assert.assertNotNull(candidates);
    }

    @Test
    public void showAllObjects() throws Exception {

    }


    @Test
    public void getCandidatesByRegion() throws Exception {

    }

}