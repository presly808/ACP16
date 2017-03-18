package week5.db.jdbc;

import com.yandex.utils.GetProperties;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConnection {

    static final Logger LOGGER = Logger.getLogger(DbConnection.class);

    private static void initDbConnection() throws IOException, ClassNotFoundException {
        LOGGER.info("LOAD DRIVER");
        Class.forName(GetProperties.getDriverPath());
    }

    public static Connection initDriverManager() throws IOException, SQLException, ClassNotFoundException {
        initDbConnection();
        LOGGER.info("INITIALIZE DRIVER CONNECTION");
        return DriverManager.getConnection(
          GetProperties.getDbURL() + GetProperties.getDbName(),
                GetProperties.getUser(), GetProperties.getPassword()
        );
    }
}
