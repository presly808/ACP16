package utils;

import models.*;

public class GenerateData {

    public static Candidate generateCandidate1(){
        return new Candidate("name1", 22, new Clan("clan1"),
                new Region("region 1"), new Interest("sport"));
    }

    public static Candidate generateCandidate2(){
        return new Candidate("name2", 50, new Clan("clan3"),
                new Region("region 2"), new Interest("space"));
    }

}
