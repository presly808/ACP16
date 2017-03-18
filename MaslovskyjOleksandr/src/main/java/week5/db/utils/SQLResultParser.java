package week5.db.utils;


import org.apache.log4j.Logger;
import week5.db.models.Candidates;
import week5.db.models.Clan;
import week5.db.models.Interests;
import week5.db.models.Region;

import java.sql.ResultSet;
import java.sql.SQLException;

public class SQLResultParser {

    static final Logger LOGGER = Logger.getLogger(SQLResultParser.class);

    public SQLResultParser() {
    }

    public Candidates getCandidateFromResults(ResultSet resultSet) throws SQLException {
        LOGGER.info("CREATE CANDIDATE");
        return new Candidates(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getInt("age"),
                resultSet.getInt("region_id"),
                resultSet.getInt("clan_id"),
                resultSet.getInt("interests_id")
        );
    }

    public Clan getClanFromResults(ResultSet resultSet) throws SQLException {
        LOGGER.info("CREATE CLAN");
        return new Clan(
                resultSet.getInt("id"),
                resultSet.getString("firstname")

        );
    }

    public Interests getInterestFromResults(ResultSet resultSet) throws SQLException {
        LOGGER.info("CREATE INTEREST");
        return new Interests(
                resultSet.getInt("id"),
                resultSet.getString("content")
        );
    }

    public Region getRegionFromResults(ResultSet resultSet) throws SQLException {
        LOGGER.info("CREATE REGION");
        return new Region(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getLong("population")
        );
    }

}
