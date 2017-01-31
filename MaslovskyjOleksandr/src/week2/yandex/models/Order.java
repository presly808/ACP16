package week2.yandex.models;

/**
 * Created by ubuntu on 31.01.17.
 */
public class Order {

    private final long id;

    private Taxi taxi;

    private Client client;

    private double price;

    private Location location;

    //TODO change id init
    public Order(Taxi taxi, Client client, double price, Location location) {
        this.taxi = taxi;
        this.client = client;
        this.price = price;
        this.location = location;
        this.id = 1;
    }

    public long getId() {
        return id;
    }

    public Taxi getTaxi() {
        return taxi;
    }

    public Client getClient() {
        return client;
    }

    public double getPrice() {
        return price;
    }

    public Location getLocation() {
        return location;
    }

    public void setTaxi(Taxi taxi) {
        this.taxi = taxi;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
