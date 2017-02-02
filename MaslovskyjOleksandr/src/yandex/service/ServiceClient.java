package yandex.service;

import yandex.controllers.ILocation;
import yandex.controllers.IServiceClient;
import yandex.exception.NoAvailableCarsException;
import yandex.exception.NoOrderFoundException;
import yandex.exception.NotValidPriceException;
import yandex.exception.WrongCoordinatesException;
import yandex.models.Client;
import yandex.models.Location;
import yandex.models.Order;
import yandex.models.Taxi;
import yandex.utils.IdGenerator;

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
