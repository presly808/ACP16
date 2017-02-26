package week5.db.models;


public class Clan {

    private int id;
    private String firstname;

    public Clan(String firstname) {
        this.firstname = firstname;
    }

    public Clan(int id, String firstname) {
        this.id = id;
        this.firstname = firstname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
