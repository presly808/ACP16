package week5.db.tests;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import week5.db.jdbc.FactoryDbConnection;
import week5.db.utils.SQLResultParser;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestSQL {

    private String regionName;
    private int limitToGet;
    private SQLResultParser sqlResultParser;
    private int minAge;
    private int maxAge;

    @Before
    public void prepareData() throws SQLException, IOException, ClassNotFoundException {
        this.regionName = "zakar";
        this.limitToGet = 2;
        this.sqlResultParser = new SQLResultParser();
        this.minAge = 30;
        this.maxAge = 50;
    }

    @Test
    public void testGetCandidatesByAge() throws SQLException, IOException, ClassNotFoundException {
        ResultSet resultSet = FactoryDbConnection.newInstance().queriesActions.getCandidatesByAge(minAge, maxAge);
        Assert.assertNotNull(resultSet);
    }

    @Test
    public void testGetCandidatesByRegionWithLimitMethod() throws SQLException, IOException, ClassNotFoundException {
        ResultSet resultSet = FactoryDbConnection.newInstance().queriesActions.getCandidatesByRegionWithLimit(regionName, limitToGet);
        sqlResultParser.getCandidateFromResults(resultSet);
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
