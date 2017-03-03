package service;

import dao.ILocation;
import dao.IServiceClient;
import exception.NoAvailableCarsException;
import exception.NoOrderFoundException;
import exception.NotValidPriceException;
import exception.WrongCoordinatesException;
import models.Location;
import models.Order;
import models.Taxi;

import models.Client;
import utils.IdGenerator;

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

    //TODO change after DB implementation
    @Override
    public Optional<Taxi> findFreeTaxi(Location currentLocation) throws NoAvailableCarsException{
        return taxiList.stream().filter(taxi -> taxi.isBusy() == false &&
                taxi.getCurrentLocation().equals(currentLocation)).findFirst();
    }
}
