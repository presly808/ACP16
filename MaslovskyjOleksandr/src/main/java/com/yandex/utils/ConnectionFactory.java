package com.yandex.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

    public static Connection getConnection() {

        try {
            Class.forName(GetProperties.getDriverPath());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            try {
                return DriverManager.getConnection(GetProperties.getDbURL() +
                                GetProperties.getDbName(),
                                    GetProperties.getUser(),
                                        GetProperties.getPassword());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return getConnection();
    }
}
