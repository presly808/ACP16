package week5.db.utils;


import org.apache.log4j.Logger;
import week5.db.models.Candidates;
import week5.db.models.Clan;
import week5.db.models.Interests;
import week5.db.models.Region;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SQLResultParser {

    static final Logger LOGGER = Logger.getLogger(SQLResultParser.class);

    public SQLResultParser() {
    }

    public List<Candidates> getCandidateFromResults(ResultSet resultSet) throws SQLException {
        List<Candidates> listOfCandidates= new ArrayList<>();
        LOGGER.info("CREATE CANDIDATE");
        while (resultSet.next()) {
            Candidates candidates = new Candidates(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getInt("age"),
                    null, null, null
            );
            LOGGER.info("ADD CANDIDATE TO LIST");
            listOfCandidates.add(candidates);
        }
        return listOfCandidates;
    }

    public List<Clan> getClanFromResults(ResultSet resultSet) throws SQLException {
        List<Clan> clanList = new ArrayList<>();
        LOGGER.info("CREATE CLAN");
        while (resultSet.next()){
            Clan clan = new Clan(
                    resultSet.getInt("id"),
                    resultSet.getString("firstname")

            );
            LOGGER.info("ADD CANDIDATE TO LIST");
            clanList.add(clan);
        }
        return clanList;
    }

    public List<Interests> getInterestFromResults(ResultSet resultSet) throws SQLException {
        LOGGER.info("CREATE INTEREST");
        List<Interests> interestsListList = new ArrayList<>();
        while (resultSet.next()) {
            Interests interests = new Interests(
                    resultSet.getInt("id"),
                    resultSet.getString("content")
            );
            LOGGER.info("ADD INTEREST TO LIST");
            interestsListList.add(interests);
        }
        return interestsListList;
    }

    public List<Region> getRegionFromResults(ResultSet resultSet) throws SQLException {
        LOGGER.info("CREATE REGION");
        List<Region> regionList= new ArrayList<>();
        while (resultSet.next()) {
            Region region = new Region(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getLong("population")
            );
            LOGGER.info("ADD REGION TO LIST");
            regionList.add(region);
        }
        return regionList;
    }

}
