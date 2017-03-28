package week5.election.dao;

import week5.election.model.Region;
import week5.election.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 05.03.17.
 */
public class RegionDao implements Dao {

    String sql;

    @Override
    public Object create(Object entity) {
        return null;
    }

    @Override
    public List getAll(int offset, int length) {
        List<Region> list = new ArrayList<>();
        sql = "SELECT id, name, population FROM Region (id, name, population)";

        try(Connection connection = ConnectionFactory.getConnection();
            Statement statement = connection.createStatement()) {
            ResultSet res = statement.executeQuery(sql);
            while (res.next()){
                list.add(new Region(res.getInt("id"),
                        res.getString("name"),
                        res.getInt("population")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Object findOne(Object o) {
        return null;
    }

    @Override
    public Object delete(Object o) {
        return null;
    }
}
