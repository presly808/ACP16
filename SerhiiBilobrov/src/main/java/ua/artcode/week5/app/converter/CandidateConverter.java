package ua.artcode.week5.app.converter;

import ua.artcode.week5.app.model.Candidate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhii on 26.02.17.
 */
public class CandidateConverter {
    public static List<Candidate> from(ResultSet resultSet) {

        List<Candidate> candidates = new ArrayList<>();

        try {
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");

                Candidate candidate = new Candidate(id,name,age);

                candidates.add(candidate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }


        return candidates;
    }
}
