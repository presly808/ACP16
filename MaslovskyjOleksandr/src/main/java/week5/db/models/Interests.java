package week5.db.models;


public class Interests {

    private int id;
    private String content;

    public Interests(String content) {
        this.content = content;
    }

    public Interests(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
