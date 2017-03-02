package week5.db.models;


public class Interests extends MainTable{

    private String content;

    public Interests(int id, String content) {
        super(id, null);
        this.content = content;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
