package models;

import java.util.List;

public class Clan extends IdGenerator{

    private List<Candidate> candidate;

    private String name;

    private int rate;

    public Clan() {
    }

    public Clan(String name) {
        this.name = name;
    }

    public Clan(String name, int rate) {
        this.name = name;
        this.rate = rate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Clan{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                '}';
    }
}
