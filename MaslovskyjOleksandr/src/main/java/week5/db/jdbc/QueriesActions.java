package week5.db.jdbc;

import org.apache.log4j.Logger;
import week5.db.models.Candidates;
import week5.db.models.Clan;
import week5.db.models.Interests;
import week5.db.models.Region;
import week5.db.utils.ConnectionAdapter;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class QueriesActions {

    static final Logger LOGGER = Logger.getLogger(QueriesActions.class);

    private Statement statement;

    public QueriesActions(Statement statement) {
        this.statement = statement;
    }

    public void executeInsertQueryIntoCandidates(Candidates candidates) throws SQLException, IOException, ClassNotFoundException {
        LOGGER.info("Execute InsertQuery Into Candidates table");
        PreparedStatement preparedStatement = ConnectionAdapter.getInsertQueryIntoCandidates();
        preparedStatement.setString(2, candidates.getName());
        preparedStatement.setInt(3, candidates.getAge());
        preparedStatement.setInt(4, candidates.getRegion_id());
        preparedStatement.setInt(5, candidates.getClan_id());
        preparedStatement.setInt(6, candidates.getInterests_id());
        preparedStatement.execute();
    }

    public void executeInsertQueryIntoInterests(Interests interests) throws SQLException, IOException, ClassNotFoundException {
        LOGGER.info("Execute InsertQuery Into Interests table");
        PreparedStatement preparedStatement = ConnectionAdapter.getInsertQueryIntoInterests();
        preparedStatement.setString(2, interests.getContent());
        preparedStatement.execute();
    }

    public void executeInsertQueryIntoRegion(Region region) throws SQLException, IOException, ClassNotFoundException {
        LOGGER.info("Execute InsertQuery Into Region table");
        PreparedStatement preparedStatement = ConnectionAdapter.getInsertQueryIntoRegion();
        preparedStatement.setString(2, region.getName());
        preparedStatement.setLong(3, region.getPopulation());
        preparedStatement.execute();
    }

    public void executeInsertQueryIntoClan(Clan clan) throws SQLException, IOException, ClassNotFoundException {
        LOGGER.info("Execute InsertQuery Into Clan table");
        PreparedStatement preparedStatement = ConnectionAdapter.getInsertQueryIntoClan();
        preparedStatement.setString(2, clan.getFirstname());
        preparedStatement.execute();
    }

    public ResultSet getCandidatesByAge(int minAge, int maxAge) throws SQLException {
        LOGGER.info("Get Candidates By Age");
        return statement.executeQuery("select * from candidates" + " where age between " + minAge + " and " + maxAge +";");
    }

    public ResultSet getCandidatesByRegionWithLimit(String regionName, int limit) throws SQLException {
        LOGGER.info("Get Candidates By Region "+ regionName +" With Limit " + limit);
        return statement.executeQuery("select * from candidates c inner join region r " +
                "on c.region_id = r.id " +
                "where r.name like '" + regionName + "' ORDER BY c.name limit " + limit + ";");
    }

    public ResultSet getMaxPopulation() throws SQLException {
        LOGGER.info("Get Max Population From Region");
        return statement.executeQuery("select max(population) from region;");
    }

    public ResultSet getQuantityOfCandidates() throws SQLException {
        LOGGER.info("Get Quantity Of Candidates");
        return statement.executeQuery("select count(name) from candidates;");
    }

}
