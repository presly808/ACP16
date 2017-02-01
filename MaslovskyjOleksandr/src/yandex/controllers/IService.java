package yandex.controllers;

import yandex.exception.NoAvailableCars;
import yandex.models.Client;
import yandex.models.Location;
import yandex.models.Order;
import yandex.models.Taxi;

import java.util.List;

/**
 * Created by ubuntu on 31.01.17.
 */
public interface IService {

    Order makeOrder(Client client, Location location) throws NoAvailableCars;

    List<Taxi> showTaxiList(Location location) throws NoAvailableCars;

}
