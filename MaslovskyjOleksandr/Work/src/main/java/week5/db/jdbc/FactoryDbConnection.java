package week5.db.jdbc;


import week5.db.utils.ConnectionAdapter;

import java.io.IOException;
import java.sql.SQLException;

public class FactoryDbConnection {

    public DaoQueriesActions queriesActions;
    private static FactoryDbConnection factory;

    private FactoryDbConnection() throws SQLException, IOException, ClassNotFoundException {
        this.queriesActions = new DaoQueriesActions(ConnectionAdapter.initStatement());
    }

    public static FactoryDbConnection newInstance() throws SQLException, IOException, ClassNotFoundException {
        if (factory == null) {
            factory = new FactoryDbConnection();
            return factory;
        } else
            return factory;
    }
}
