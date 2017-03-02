package week5.db.tests;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import week5.db.jdbc.FactoryDbConnection;
import week5.db.models.Candidates;
import week5.db.models.Clan;
import week5.db.models.Interests;
import week5.db.models.Region;
import week5.db.utils.SQLResultParser;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TestSQL {

    private String regionName;
    private int limitToGet;
    private SQLResultParser sqlResultParser;
    private int minAge;
    private int maxAge;
    private List<Candidates> candidates;
    private List<Region> regions;
    private List<Interests> interestses;
    private List<Clan> clanList;

    @Before
    public void prepareData() throws SQLException, IOException, ClassNotFoundException {
        this.regionName = "zakar";
        this.limitToGet = 2;
        this.sqlResultParser = new SQLResultParser();
        this.minAge = 30;
        this.maxAge = 50;
        this.candidates = new ArrayList<>();
        this.regions = new ArrayList<>();
        this.interestses = new ArrayList<>();
        this.clanList = new ArrayList<>();
    }

    @Test
    public void testGetCandidatesByAge() throws SQLException, IOException, ClassNotFoundException {
        candidates = FactoryDbConnection.newInstance().queriesActions.getCandidatesByAge(minAge, maxAge);
        Assert.assertNotNull(candidates);
    }

    @Test
    public void testGetCandidatesByRegionWithLimitMethod() throws SQLException, IOException, ClassNotFoundException {
        candidates = FactoryDbConnection.newInstance().queriesActions.getCandidatesByRegionWithLimit(regionName, limitToGet);
        Assert.assertNotNull(candidates);
    }

    @Test
    public void testGetMaxPopulation() throws SQLException, IOException, ClassNotFoundException {
        FactoryDbConnection.newInstance().queriesActions.getMaxPopulation();
    }

    @Test
    public void testGetQuantityOfCandidates() throws SQLException, IOException, ClassNotFoundException {
        FactoryDbConnection.newInstance().queriesActions.getQuantityOfCandidates();
    }

}
