package week5.db.models;


public class Candidates extends MainTable{

    private int age;
    private Region region;
    private Clan clan;
    private Interests interests;

    public Candidates(int id, String name) {
        super(id, name);
    }

    public Candidates(int id, String name, int age, Region region, Clan clan, Interests interests) {
        super(id, name);
        this.age = age;
        this.region = region;
        this.clan = clan;
        this.interests = interests;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Clan getClan() {
        return clan;
    }

    public void setClan(Clan clan) {
        this.clan = clan;
    }

    public Interests getInterests() {
        return interests;
    }

    public void setInterests(Interests interests) {
        this.interests = interests;
    }
}
