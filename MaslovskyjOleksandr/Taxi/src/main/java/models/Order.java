package models;

import controllers.ILocation;
import utils.DateGenerator;
import utils.IdGenerator;

import java.util.UUID;

public class Order {

    private final UUID id;
    private Taxi taxi;
    private Client client;
    private double price;
    private ILocation location;
    private String orderData;

    public Order(Taxi taxi, Client client, double price, ILocation location) {
        this.taxi = taxi;
        this.client = client;
        this.price = price;
        this.location = location;
        this.id = IdGenerator.generateId();
        this.orderData = DateGenerator.getCurrentDate();
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

    public ILocation getLocation() {
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

    public void setLocation(ILocation location) {
        this.location = location;
    }
}
