package week5.db.models;


public class Candidates {

    private int id;
    private String name;
    private int age;
    private int region_id;
    private int clan_id;
    private int interests_id;

    public Candidates(String name, int age, int region_id, int clan_id, int interests_id) {
        this.name = name;
        this.age = age;
        this.region_id = region_id;
        this.clan_id = clan_id;
        this.interests_id = interests_id;
    }

    public Candidates(int id, String name, int age, int region_id, int clan_id, int interests_id) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.region_id = region_id;
        this.clan_id = clan_id;
        this.interests_id = interests_id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getRegion_id() {
        return region_id;
    }

    public void setRegion_id(int region_id) {
        this.region_id = region_id;
    }

    public int getClan_id() {
        return clan_id;
    }

    public void setClan_id(int clan_id) {
        this.clan_id = clan_id;
    }

    public int getInterests_id() {
        return interests_id;
    }

    public void setInterests_id(int interests_id) {
        this.interests_id = interests_id;
    }
}
