package com.yandex.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

    public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
        Class.forName(GetProperties.getDriverPath());
        return DriverManager.getConnection(GetProperties.getDbURL() +
                        GetProperties.getDbName(),
                            GetProperties.getUser(),
                                GetProperties.getPassword());
    }
}
