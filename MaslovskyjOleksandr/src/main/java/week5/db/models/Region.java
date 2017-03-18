package week5.db.models;


public class Region {

    private int id;
    private String name;
    private long population;

    public Region(String name, long population) {
        this.name = name;
        this.population = population;
    }

    public Region(int id, String name, long population) {
        this.id = id;
        this.name = name;
        this.population = population;
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

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }
}
