package week5.db.jdbc;


import week5.db.utils.ConnectionAdapter;

import java.io.IOException;
import java.sql.SQLException;

public class FactoryDbConnection {

    public QueriesActions queriesActions;

    private FactoryDbConnection() throws SQLException, IOException, ClassNotFoundException {
        this.queriesActions = new QueriesActions(ConnectionAdapter.initStatement());
    }

    public static FactoryDbConnection newInstance() throws SQLException, IOException, ClassNotFoundException {
        return new FactoryDbConnection();
    }
}
