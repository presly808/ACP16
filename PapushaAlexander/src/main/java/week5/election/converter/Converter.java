package week5.election.converter;

import week5.election.model.*;

/**
 * Created by alex on 26.02.17.
 */
public class Converter {

    public Clan newClan(int id, String name){
        return new Clan(id, name);
    }

    public Region newRegion(int id, String name, int population){
        return new Region(id, name, population);
    }

    public Candidate newCandidate(int id, String name, Clan clan, Region region, int age){
        return new Candidate(id, name, clan, region, age);
    }

    public Interests newInterests(int id, String name){
        return new Interests(id, name);
    }

    public CandidatesInterests newCandidatesInterests(Candidate candidat, Interests interests){
        return new CandidatesInterests(candidat, interests);
    }


}
