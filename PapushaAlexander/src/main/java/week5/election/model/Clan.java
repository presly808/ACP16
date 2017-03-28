package week5.election.model;

/**
 * Created by alex on 26.02.17.
 */
public class Clan {

    private int id;
    private String name;

    public Clan(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
