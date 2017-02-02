package yandex.models;

import java.util.UUID;

/**
 * Created by ubuntu on 31.01.17.
 */
public class Order {

    private final UUID id;

    private Taxi taxi;

    private Client client;

    private double price;

    private Location location;

    public Order(Taxi taxi, Client client, double price, Location location, UUID id) {
        this.taxi = taxi;
        this.client = client;
        this.price = price;
        this.location = location;
        this.id = id;
    }

    public UUID getId() {
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

    public void setTaxi(Taxi taxi){
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
