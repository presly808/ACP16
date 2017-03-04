package utils;

import models.*;

public class GenerateData {

    public static Candidate generateCandidate(){
        return new Candidate("name1", 22, new Clan("clan1"),
                new Region(RegionType.REGION_1), new Interest(InterestsType.FINANCE));
    }

}
