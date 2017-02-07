package com.yandex.models;

import com.yandex.controllers.ILocation;
import com.yandex.utils.IdGenerator;

import java.util.UUID;

/**
 * Created by ubuntu on 31.01.17.
 */
public class Order {

    private final UUID id;
    private Taxi taxi;
    private Client client;
    private double price;
    private ILocation location;

    public Order(Taxi taxi, Client client, double price, ILocation location) {
        this.taxi = taxi;
        this.client = client;
        this.price = price;
        this.location = location;
        this.id = IdGenerator.generateId();
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
