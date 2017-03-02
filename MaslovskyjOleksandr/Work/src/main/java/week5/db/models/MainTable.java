package week5.db.models;


public class MainTable {

    private int id;
    private String name;

    public MainTable(int id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MainTable mainTable = (MainTable) o;

        return id == mainTable.id;

    }

    @Override
    public int hashCode() {
        return id;
    }
}
