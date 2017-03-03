package db;


import dao.IQuery;
import exception.DbNotAvailableException;
import utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class PrepareQuery implements IQuery {

    private Connection connection;
    private PreparedStatement preparedStatement;

    public PrepareQuery() throws SQLException {
        this.connection = ConnectionFactory.getConnection();
        this.preparedStatement = connection.prepareStatement("");
    }

    @Override
    public boolean insertInto(String tableName, List<String> param) throws DbNotAvailableException {
        try {
            preparedStatement.executeUpdate(
                    String.format("INSERT INTO " + tableName +
                            "() VALUES (?,?,?,?) ")
            );
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public String selectFrom(String tableName, List<String> param) throws DbNotAvailableException {
        return null;
    }
}
