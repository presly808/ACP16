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
import org.springframework.stereotype.Component;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;
import service.ServiceCandidate;
import utils.UtilsServiceCandidate;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import static org.hamcrest.Matchers.*;
import static utils.GenerateData.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class CandidateDaoTest {

    private int expectedResult;
    private int minAge;
    private int maxAge;
    private RegionType region;
    private Candidate candidate1;
    private Candidate candidate2;

    @PersistenceContext
    private EntityManager manager;
    @Autowired
    private ServiceCandidate candidateService;
    @Autowired
    private UtilsServiceCandidate utilsServiceCandidate;

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
    public void saveCandidate() throws Exception {
        boolean actual = candidateService.saveCandidate(candidate1);
        Assert.assertTrue(actual);
        Assert.assertThat(getTableResult(), hasItem(candidate1));
    }

    @Test
    public void testDeleteCandidate() throws NoCandidatesFoundException, NotAvailableTableException {
        candidateService.saveCandidate(candidate2);
        candidateService.deleteCandidate(candidate2.getId());
        Assert.assertTrue(getTableResult().isEmpty());
    }

    @Test
    public void getCandidatesByAge() throws Exception {
        candidateService.saveCandidate(candidate1);
        List<Candidate> candidates = candidateService.getCandidatesByAge(minAge, maxAge);
        Assert.assertThat(candidates, hasItem(candidate1));
        candidateService.saveCandidate(candidate2);
        candidates = candidateService.getCandidatesByAge(minAge, maxAge);
        Assert.assertTrue(expectedResult == candidates.size());
        Assert.assertThat(candidates, allOf(hasItem(candidate1), hasItem(candidate2)));
    }

    @Test
    public void getCandidatesByRegion() throws Exception {
        candidateService.saveCandidate(candidate1);
        candidateService.saveCandidate(candidate2);
        List<Candidate> candidateList = candidateService.getCandidatesByRegion(region);
        Assert.assertTrue(candidateList.size() == 1);
        Assert.assertThat(candidateList, contains(candidate2));
    }

    @Test
    public void showAllObjects() throws Exception {
        candidateService.saveCandidate(candidate1);
        candidateService.saveCandidate(candidate2);
        List<Candidate> candidateList = candidateService.getAllCandidates();
        Assert.assertNotNull(candidateList);
        Assert.assertThat(candidateList, allOf(hasItem(candidate1), hasItem(candidate2)));
    }

    private void clearDataFromDatabase() {
        utilsServiceCandidate.deleteAllCandidates();
        utilsServiceCandidate.deleteAllClans();
        utilsServiceCandidate.deleteAllInterests();
        utilsServiceCandidate.deleteAllRegions();
    }

    private List<Candidate> getTableResult() throws NoCandidatesFoundException {
        return utilsServiceCandidate.getAllCandidates();
    }
}