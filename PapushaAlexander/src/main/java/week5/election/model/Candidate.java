package week5.election.model;

/**
 * Created by alex on 26.02.17.
 */
public class Candidate {
    private int id;
    private String name;
    private Clan clan;
    private Region region;
    private int age;

    public Candidate(int id, String name, Clan clan, Region region, int age) {
        this.id = id;
        this.name = name;
        this.clan = clan;
        this.region = region;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
