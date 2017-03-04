package dao;

import exceptions.NoCandidatesFoundException;
import exceptions.NotAvailableTableException;
import models.Candidate;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import utils.DbOperationFactory;

import java.util.List;

import static utils.GenerateData.*;

public class CandidateDaoTest {

    public int expectedResult;
    private int minAge;
    private int maxAge;
    private Candidate candidate1;
    private Candidate candidate2;

    @Before
    public void dataPreparation(){
        minAge = 20;
        maxAge = 50;
        this.candidate1 = generateCandidate1();
        this.candidate2 = generateCandidate2();
        this.expectedResult = 2;
    }

    @Test
    public void insertIntoTable() throws Exception {
        boolean actual = DbOperationFactory.newInstance().createDaoCandidate().insertIntoTable(candidate1);
        Assert.assertTrue(actual);
    }

    @Test
    public void testRemoveCandidateById() throws NoCandidatesFoundException, NotAvailableTableException {
        DbOperationFactory.newInstance().createDaoCandidate().insertIntoTable(candidate2);
        boolean actual = DbOperationFactory.newInstance().createDaoCandidate().removeCandidateById(candidate2.getId());
        Assert.assertTrue(actual);
    }

    @Test
    public void getCandidatesByAge() throws Exception {
        DbOperationFactory.newInstance().createDaoCandidate().insertIntoTable(candidate1);
        List<Candidate> candidates = DbOperationFactory.newInstance().createDaoCandidate().getCandidatesByAge(minAge, maxAge);
        Assert.assertTrue(candidates.contains(candidate1));
        DbOperationFactory.newInstance().createDaoCandidate().insertIntoTable(candidate2);
        candidates = DbOperationFactory.newInstance().createDaoCandidate().getCandidatesByAge(minAge, maxAge);
        Assert.assertTrue(expectedResult == candidates.size());
    }

    @Test
    public void showAllObjects() throws Exception {

    }


    @Test
    public void getCandidatesByRegion() throws Exception {

    }

}