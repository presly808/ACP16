package week2.yandex.models;

/**
 * Created by ubuntu on 31.01.17.
 */
public class User {

    private final long id;

    private String name;

    private String phone;

    //TODO change id init
    public User(String name, String phone) {
        this.name = name;
        this.phone = phone;
        this.id = 1;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
