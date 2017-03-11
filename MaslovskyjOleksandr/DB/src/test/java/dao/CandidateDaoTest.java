package dao;

import exceptions.NoCandidatesFoundException;
import exceptions.NotAvailableTableException;
import models.Candidate;
import models.RegionType;
import org.junit.After;
import org.junit.Assert;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import utils.DbOperationFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static utils.GenerateData.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class CandidateDaoTest {

    public static final String DROP_TABLE_CANDIDATES_CLANS_HIBERNATE_SEQUENCE_INTERESTS_REGIONS =
            "DROP TABLE candidates, clans, hibernate_sequence, interests, regions;";
    private int expectedResult;
    private int minAge;
    private int maxAge;
    private RegionType region;
    private Candidate candidate1;
    private Candidate candidate2;

    @PersistenceContext
    private EntityManager manager;

    @Before
    public void dataPreparation(){
        minAge = 20;
        maxAge = 50;
        this.region = RegionType.REGION_4;
        this.expectedResult = 2;
        this.candidate1 = generateCandidate1();
        this.candidate2 = generateCandidate2();
    }

    @After
    public void cleanData(){
        clearDataFromDatabase();
    }

    @Test
    public void insertIntoTable() throws Exception {
        DbOperationFactory.newInstance().createDaoCandidate().insertIntoTable(candidate1);
        Assert.assertThat(getTableResult(), hasItem(candidate1));
    }

    @Test
    public void testRemoveCandidateById() throws NoCandidatesFoundException, NotAvailableTableException {
        DbOperationFactory.newInstance().createDaoCandidate().insertIntoTable(candidate2);
        DbOperationFactory.newInstance().createDaoCandidate().removeCandidateById(candidate2.getId());
        Assert.assertTrue(getTableResult().isEmpty());
    }

    @Test
    public void getCandidatesByAge() throws Exception {
        DbOperationFactory.newInstance().createDaoCandidate().insertIntoTable(candidate1);
        List<Candidate> candidates = DbOperationFactory.newInstance().createDaoCandidate().getCandidatesByAge(minAge, maxAge);
        Assert.assertThat(candidates, hasItem(candidate1));
        DbOperationFactory.newInstance().createDaoCandidate().insertIntoTable(candidate2);
        candidates = DbOperationFactory.newInstance().createDaoCandidate().getCandidatesByAge(minAge, maxAge);
        Assert.assertTrue(expectedResult == candidates.size());
        Assert.assertThat(candidates, allOf(hasItem(candidate1), hasItem(candidate2)));
    }

    @Test
    public void getCandidatesByRegion() throws Exception {
        DbOperationFactory.newInstance().createDaoCandidate().insertIntoTable(candidate1);
        DbOperationFactory.newInstance().createDaoCandidate().insertIntoTable(candidate2);
        List<Candidate> candidateList = DbOperationFactory.newInstance().createDaoCandidate().getCandidatesByRegion(region);
        Assert.assertTrue(candidateList.size() == 1);
        Assert.assertThat(candidateList, contains(candidate2));
    }

    @Test
    public void showAllObjects() throws Exception {
        DbOperationFactory.newInstance().createDaoCandidate().insertIntoTable(candidate1);
        DbOperationFactory.newInstance().createDaoCandidate().insertIntoTable(candidate2);
        List<Candidate> candidateList = DbOperationFactory.newInstance().createDaoCandidate().showAllObjects();
        Assert.assertNotNull(candidateList);
        Assert.assertThat(candidateList, allOf(hasItem(candidate1), hasItem(candidate2)));
    }

    private void clearDataFromDatabase() {
        manager.getTransaction().begin();
        manager.createNativeQuery(DROP_TABLE_CANDIDATES_CLANS_HIBERNATE_SEQUENCE_INTERESTS_REGIONS);
        manager.getTransaction().commit();
    }

    private List<Candidate> getTableResult(){
        List<Candidate> result = manager.createNativeQuery("SELECT * FROM candidates", Candidate.class).getResultList();
        return result;
    }
}