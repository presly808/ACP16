import com.google.gson.Gson;
import models.Candidate;
import models.Clan;
import models.Interest;
import models.Region;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestListToJson {

    private List<Candidate> candidates;

    @Before
    public void prepareData(){
        candidates = new ArrayList<>();
        candidates.add(new Candidate("name1", 23, new Clan("clan"),
                new Region("region1"), new Interest("sport")));
        candidates.add(new Candidate("name2", 27, new Clan("clan2"),
                new Region("region2"), new Interest("sport2")));
    }


    @Test
    public void checkListToJsonMethod(){
        String jsonString = new Gson().toJson(candidates);
        //Assert.assertTrue(jsonString.equals("[{\"name\":\"name1\",\"age\":23,\"clan\":{\"name\":\"clan\",\"rate\":0,\"id\":0},\"region\":{\"regionType\":\"region1\",\"id\":0},\"interest\":{\"type\":\"sport\",\"id\":0},\"id\":0},{\"name\":\"name2\",\"age\":27,\"clan\":{\"name\":\"clan2\",\"rate\":0,\"id\":0},\"region\":{\"regionType\":\"region2\",\"id\":0},\"interest\":{\"type\":\"sport2\",\"id\":0},\"id\":0}]\n"));
    }

}
