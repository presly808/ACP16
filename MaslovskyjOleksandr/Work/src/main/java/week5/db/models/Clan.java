package week5.db.models;


public class Clan extends MainTable{

    private String firstname;

    public Clan(int id) {
        super(id, null);
    }

    public Clan(int id, String firstname) {
        super(id, null);
        this.firstname = firstname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
}
