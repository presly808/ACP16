package models;

import javax.persistence.*;

@Entity
@Table(name = "candidates")
@NamedQuery(name="getAllCandidates", query ="select c from Candidate c")
public class Candidate extends IdGenerator{

    @Column(nullable = false, length = 40)
    private String name;

    @Column(nullable = false, length = 10)
    private int age;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "clan_id", referencedColumnName = "id")
    private Clan clan;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    private Region region;

    @ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "interest_id", referencedColumnName = "id")
    private Interest interest;

    public Candidate() {
    }

    public Candidate(String name, int age, Clan clan, Region region, Interest interest) {
        this.name = name;
        this.age = age;
        this.clan = clan;
        this.region = region;
        this.interest = interest;
    }

    public Candidate(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Interest getInterest() {
        return interest;
    }

    public void setInterest(Interest interest) {
        this.interest = interest;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", clan=" + clan +
                ", region=" + region +
                ", interest=" + interest +
                '}';
    }
}
