package jdbcTest;

import com.ibatis.common.jdbc.ScriptRunner;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import week5.model.Candidate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.when;


/**
 * Created by Vitalii on 25.02.2017.
 */
public class DBTestViaJDBC {

    protected static Connection connection;
    protected static Statement statement;
    protected static String aSQLScriptFilePath = "E:\\Programming\\ACP16\\balitskiyVitalii\\src\\main\\java\\week5\\initDB.sql";
    protected List<Integer> candidateInRegion;
    protected Candidate candidate;

    @BeforeClass
    public static void initDB() throws ClassNotFoundException, IllegalAccessException, InstantiationException, SQLException {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        connection = DriverManager.getConnection("jdbc:mysql://localhost/election?" +
                "user=root&password=root");
        statement = connection.createStatement();
        try {
            ScriptRunner sr = new ScriptRunner(connection, false, false);

            // Give the input file to Reader
            Reader reader = new BufferedReader(
                    new FileReader(aSQLScriptFilePath));

            // Exctute script
            sr.runScript(reader);

        } catch (Exception e) {
            System.err.println("Failed to Execute " + aSQLScriptFilePath
                    + " The error is " + e.getMessage());
        }
    }

    @AfterClass
    public static void clearAfterTesting() {
        try {
            statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 0;");
            statement.executeUpdate("TRUNCATE candidates;");
            statement.executeUpdate("TRUNCATE clans;");
            statement.executeUpdate("TRUNCATE interests;");
            statement.executeUpdate("TRUNCATE cand_interest;");
            statement.executeUpdate("TRUNCATE regions;");
            statement.executeUpdate("SET FOREIGN_KEY_CHECKS = 1;");
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(statement != null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Before
    public void setUp() throws SQLException {
        candidate = new Candidate(1, "Petrenko Ivan", 35, 1);
        candidateInRegion = Arrays.asList(1, 1, 2);
    }

    @Test
    public void dbGetFirstTest() throws SQLException {
        ResultSet set = statement.executeQuery("SELECT * FROM candidates c left join regions r on c.region = r.id WHERE c.id = 1");
        Candidate gotCandidate = null;
        while (set.next()) {
            gotCandidate = new Candidate(set.getInt("id"), set.getString("fullname"), set.getInt("age"), set.getInt("region"));
        }

        assertThat(candidate, is(gotCandidate));

    }

    @Test
    public void dbGetCountOfCandidatesTest() {
        ResultSet set = null;
        try {
            set = statement.executeQuery("SELECT count(id) count FROM candidates c");
            int candidatesCount = 0;
            while (set.next()) {
                candidatesCount = set.getInt("count");
            }
            assertThat(candidatesCount, is(4));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    @Test
    public void dbGetCountOfCandidatesInRegionsTest() {
        ResultSet set = null;
        try {
            set = statement.executeQuery("SELECT count(r.id) count FROM candidates c left join regions r on c.region = r.id group by c.region");
            List<Integer> candidatesInRegion = new ArrayList<>();
            while (set.next()) {
                candidatesInRegion.add(set.getInt("count"));
            }
            assertThat(candidatesInRegion, is(candidateInRegion));
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (set != null) {
                try {
                    set.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}