package week5.db.models;


public class Region extends MainTable{

    private long population;

    public Region(int id, String name, long population) {
        super(id, name);
        this.population = population;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }
}
