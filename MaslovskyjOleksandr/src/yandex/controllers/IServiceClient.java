package yandex.controllers;

import yandex.exception.NoAvailableCarsException;
import yandex.exception.NoOrderFoundException;
import yandex.models.Client;
import yandex.models.Location;
import yandex.models.Order;
import yandex.models.Taxi;

import java.util.List;

/**
 * Created by ubuntu on 31.01.17.
 */
public interface IServiceClient {

    Order makeOrder(Client client, Location location) throws NoAvailableCarsException;

    List<Taxi> showTaxiList(Location location) throws NoAvailableCarsException;

    boolean cancelOrder(Order order) throws NoOrderFoundException;

}
