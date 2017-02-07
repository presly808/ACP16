package com.yandex.service;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.yandex.controllers.ILocation;
import com.yandex.controllers.IServiceClient;
import com.yandex.exception.NoAvailableCarsException;
import com.yandex.exception.NoOrderFoundException;
import com.yandex.exception.NotValidPriceException;
import com.yandex.exception.WrongCoordinatesException;
import com.yandex.models.Location;
import com.yandex.models.Order;
import com.yandex.models.Taxi;
import com.yandex.utils.IdGenerator;
import com.yandex.models.Client;

import java.util.List;
import java.util.Optional;


public class ServiceClient implements IServiceClient {

    private Client client;
    private List<Taxi> taxiList;
    private ILocation currentLocation;
    private Taxi taxi;
    private Order order;

    public ServiceClient() {
    }

    public ServiceClient(String name, String phone, ILocation location) {
        this.client = new Client(name, phone, IdGenerator.generateId());
        this.currentLocation = location;
    }

    @Override
    public Order makeOrder(Location currentLocation, Location destination) throws NoAvailableCarsException, NotValidPriceException, WrongCoordinatesException {
        taxi = findFreeTaxi(currentLocation).get();
        order = new Order(taxi, client, new ServiceLocation().
                calculatePrice(currentLocation, destination), (ILocation) currentLocation);
        return order;
    }

    //TODO need to implement DB, after that call saveOrderToDB Method
    @Override
    public boolean confirmOrder() throws NoOrderFoundException {
        return false;
    }

    //TODO implement after DB
    @Override
    public List<Taxi> showTaxiList() throws NoAvailableCarsException {
        return null;
    }

    @Override
    public boolean cancelOrder(Order order) throws NoOrderFoundException {
        if (order.getId() != null) {
            order.getTaxi().setBusy(false);
            order = null;
            return true;
        }
        return false;
    }

    @Override
    public Optional<Taxi> findFreeTaxi(Location currentLocation) throws NoAvailableCarsException{
        return taxiList.stream().filter(taxi -> taxi.isBusy() == false &&
                taxi.getCurrentLocation().equals(currentLocation)).findFirst();
    }
}
