package ua.artcode.week5.app.model;

/**
 * Created by serhii on 26.02.17.
 */
public class Region {

    private int id;
    private String name;
    private long population;

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
