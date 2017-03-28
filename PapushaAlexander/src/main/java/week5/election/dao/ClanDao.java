package week5.election.dao;

import week5.election.model.Clan;
import week5.election.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by alex on 03.03.17.
 */
public class ClanDao implements Dao<Clan,Integer>{
    String sql;
    @Override
    public Clan create(Clan entity) {

        sql = "INSERT INTO Clan (id, name) VALUES ?, ? ";

        try(Connection connection = ConnectionFactory.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1, entity.getId());
            preparedStatement.setString(2, entity.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return entity;
    }

    @Override
    public List getAll(int offset, int length) {
        return null;
    }

    @Override
    public Clan findOne(Integer integer) {
        return null;
    }

    @Override
    public Clan delete(Integer integer) {
        return null;
    }

}
