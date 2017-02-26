package ua.artcode.week5.app.dao;

import ua.artcode.week5.app.converter.CandidateConverter;
import ua.artcode.week5.app.model.Candidate;
import ua.artcode.week5.app.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by serhii on 26.02.17.
 */
public class CandidateDaoImpl implements CandidateDao {


    @Override
    public Candidate create(Candidate entity) {
        return null;
    }

    @Override
    public List<Candidate> getAll(int offset, int length) {
        return null;
    }

    @Override
    public Candidate findOne(Integer integer) {
        return null;
    }

    @Override
    public Candidate delete(Integer integer) {
        return null;
    }

    @Override
    public List<Candidate> getByAge(int lowAge, int hightAge) {

        String sql = "SELECT id, name, age FROM candidates c WHERE c.age BETWEEN ? and ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(sql)){
            preparedStatement.setInt(1,lowAge);
            preparedStatement.setInt(2,hightAge);

            ResultSet resultSet = preparedStatement.executeQuery();

            return CandidateConverter.from(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}
