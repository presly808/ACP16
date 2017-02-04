package com.yandex.service;

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


public class ServiceClient implements IServiceClient {

    private Client client;

    private List<Taxi> taxiList;

    private ILocation currentLocation;

    private Taxi taxi;

    public ServiceClient(String name, String phone, ILocation location) {
        this.client = new Client(name, phone, IdGenerator.generateId());
        this.currentLocation = location;
    }

    @Override
    public Order makeOrder(Location currentLocation, Location destination) throws NoAvailableCarsException, NotValidPriceException, WrongCoordinatesException {
        taxi = findFreeTaxi(currentLocation);
        return new Order(taxi, client, new ServiceLocation().
                calculatePrice(currentLocation, destination), (ILocation) currentLocation);
    }

    @Override
    public List<Taxi> showTaxiList() throws NoAvailableCarsException {
        return null;
    }

    @Override
    public boolean cancelOrder(Order order) throws NoOrderFoundException {
        return false;
    }

    @Override
    public Taxi findFreeTaxi(Location currentLocation) throws NoAvailableCarsException{
        return taxiList.stream().filter(taxi -> taxi.isBusy() == false &&
                taxi.getCurrentLocation().equals(currentLocation)).findFirst().get();
    }

}
