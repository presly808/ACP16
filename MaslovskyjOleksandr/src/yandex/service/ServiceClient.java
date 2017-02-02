package yandex.service;

import yandex.controllers.IServiceClient;
import yandex.exception.NoAvailableCarsException;
import yandex.exception.NoOrderFoundException;
import yandex.models.Client;
import yandex.models.Location;
import yandex.models.Order;
import yandex.models.Taxi;
import yandex.utils.IdGenerator;

import java.util.List;

/**
 * Created by ubuntu on 02.02.17.
 */
public class ServiceClient implements IServiceClient {

    private Client client;

    private Location currentLocation;

    public ServiceClient(String name, String phone, Location currentLocation) {
        this.client = new Client(name, phone, IdGenerator.generateId());
        this.currentLocation = currentLocation;
    }

    @Override
    public Order makeOrder(Client client, Location location) throws NoAvailableCarsException {
        return null;
    }

    @Override
    public List<Taxi> showTaxiList(Location location) throws NoAvailableCarsException {
        return null;
    }

    @Override
    public boolean cancelOrder(Order order) throws NoOrderFoundException {
        return false;
    }
}
