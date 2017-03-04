package utils;

import models.*;

public class GenerateData {

    public static Candidate generateCandidate1(){
        return new Candidate("name1", 22, new Clan("clan1"),
                new Region(RegionType.REGION_1), new Interest(InterestsType.FINANCE));
    }

    public static Candidate generateCandidate2(){
        return new Candidate("name2", 50, new Clan("clan3"),
                new Region(RegionType.REGION_4), new Interest(InterestsType.SPACE));
    }

}
