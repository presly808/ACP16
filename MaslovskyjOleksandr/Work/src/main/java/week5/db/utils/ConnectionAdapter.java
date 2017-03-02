package week5.db.utils;


import org.apache.log4j.Logger;
import week5.db.jdbc.DbConnection;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class ConnectionAdapter {

    private static Logger LOGGER = Logger.getLogger(ConnectionAdapter.class);

    public static Statement initStatement() throws SQLException, IOException, ClassNotFoundException {
        LOGGER.info("CREATE STATEMENT");
        return DbConnection.initDriverManager().createStatement();
    }

    public static PreparedStatement getInsertQueryIntoCandidates() throws SQLException, IOException, ClassNotFoundException {
        return DbConnection.initDriverManager().prepareStatement("INSERT INTO candidates (" +
                "name, age, region_id, clan_id, interests_id) VALUES (?,?,?,?,?)");
    }

    public static PreparedStatement getInsertQueryIntoInterests() throws SQLException, IOException, ClassNotFoundException {
        return DbConnection.initDriverManager().prepareStatement("INSERT INTO interests (" +
                "content) VALUES (?)");
    }

    public static PreparedStatement getInsertQueryIntoRegion() throws SQLException, IOException, ClassNotFoundException {
        return DbConnection.initDriverManager().prepareStatement("INSERT INTO region (" +
                "name, population) VALUES (?,?)");
    }

    public static PreparedStatement getInsertQueryIntoClan() throws SQLException, IOException, ClassNotFoundException {
        return DbConnection.initDriverManager().prepareStatement("INSERT INTO clan (firstname) VALUES (?)");
    }

}
