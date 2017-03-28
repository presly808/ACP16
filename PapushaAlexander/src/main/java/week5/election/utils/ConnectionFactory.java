package week5.election.utils;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

import static week5.election.utils.PropertiesHolder.get;

/**
 * Created by alex on 03.03.17.
 */
public class ConnectionFactory {

    static {
        try {
            Class.forName(get("db.driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("can not init driver for db");
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = get("db.url") + "/" + get("db.name");
        return DriverManager.getConnection(url, get("db.user"), get("db.pass"));
    }
}
