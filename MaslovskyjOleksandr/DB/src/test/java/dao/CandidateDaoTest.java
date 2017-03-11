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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import service.ServiceCandidate;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import static org.hamcrest.Matchers.*;
import static utils.GenerateData.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfiguration.class, loader = AnnotationConfigContextLoader.class)
public class CandidateDaoTest {

    public static final String DROP_TABLE_CANDIDATES_CLANS_HIBERNATE_SEQUENCE_INTERESTS_REGIONS =
            "DROP TABLE candidates, clans, hibernate_sequence, interests, regions;";
    private int expectedResult;
    private int minAge;
    private int maxAge;
    private RegionType region;
    private Candidate candidate1;
    private Candidate candidate2;

    @Autowired
    private EntityManager manager;

    @Autowired
    private ServiceCandidate candidate;

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
        candidate.saveCandidate(candidate1);
        Assert.assertThat(getTableResult(), hasItem(candidate1));
    }

    @Test
    public void testDeleteCandidate() throws NoCandidatesFoundException, NotAvailableTableException {
        candidate.saveCandidate(candidate2);
        candidate.deleteCandidate(candidate2.getId());
        Assert.assertTrue(getTableResult().isEmpty());
    }

    @Test
    public void getCandidatesByAge() throws Exception {
        candidate.saveCandidate(candidate1);
        List<Candidate> candidates = candidate.getCandidatesByAge(minAge, maxAge);
        Assert.assertThat(candidates, hasItem(candidate1));
        candidate.saveCandidate(candidate2);
        candidates = candidate.getCandidatesByAge(minAge, maxAge);
        Assert.assertTrue(expectedResult == candidates.size());
        Assert.assertThat(candidates, allOf(hasItem(candidate1), hasItem(candidate2)));
    }

    @Test
    public void getCandidatesByRegion() throws Exception {
        candidate.saveCandidate(candidate1);
        candidate.saveCandidate(candidate2);
        List<Candidate> candidateList = candidate.getCandidatesByRegion(region);
        Assert.assertTrue(candidateList.size() == 1);
        Assert.assertThat(candidateList, contains(candidate2));
    }

    @Test
    public void showAllObjects() throws Exception {
        candidate.saveCandidate(candidate1);
        candidate.saveCandidate(candidate2);
        List<Candidate> candidateList = candidate.getAllCandidates();
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