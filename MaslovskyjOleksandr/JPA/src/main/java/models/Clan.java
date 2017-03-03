package models;

import javax.persistence.*;

@Table(name = "clans")
@Entity
public class Clan extends IdGenerator{

    @OneToMany(mappedBy = "clan")
    private Candidate candidate;

    @Column(unique = true, name = "name", nullable = false)
    private String name;

    @Column(name = "rate", nullable = false)
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
