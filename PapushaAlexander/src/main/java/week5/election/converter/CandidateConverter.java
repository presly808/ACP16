package week5.election.converter;

import week5.election.model.Candidate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by alex on 03.03.17.
 */
public class CandidateConverter {
    public static List<Candidate> from(ResultSet resultSet) {

        List<Candidate> candidates = new ArrayList<>();

        try {
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                Candidate candidate = new Candidate(id, name, null, null, age);

                candidates.add(candidate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return candidates;
    }
}
