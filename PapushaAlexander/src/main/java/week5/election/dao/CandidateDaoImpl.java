package week5.election.dao;

import week5.election.converter.CandidateConverter;
import week5.election.model.Candidate;
import week5.election.utils.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

/**
 * Created by alex on 03.03.17.
 */
public class CandidateDaoImpl implements CandidateDao {
    String sql;


    @Override
    public Candidate create(Candidate entity) {
        sql = "";
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
    public List<Candidate> getByAge(int lowAge, int heightAge) {

        sql = "SELECT id, name, age FROM Candidates c WHERE c.age BETWEEN ? and ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement preparedStatement =
                     connection.prepareStatement(sql)){
            preparedStatement.setInt(1,lowAge);
            preparedStatement.setInt(2, heightAge);

            ResultSet resultSet = preparedStatement.executeQuery();

            return CandidateConverter.from(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Collections.emptyList();
    }
}
