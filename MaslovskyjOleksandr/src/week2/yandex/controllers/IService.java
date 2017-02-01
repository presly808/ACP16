package week2.yandex.controllers;

import week2.yandex.exception.NoAvailableCars;
import week2.yandex.models.Client;
import week2.yandex.models.Location;
import week2.yandex.models.Order;
import week2.yandex.models.Taxi;

import java.util.List;

/**
 * Created by ubuntu on 31.01.17.
 */
public interface IService {

    Order makeOrder(Client client, Location location) throws NoAvailableCars;

    List<Taxi> showTaxiList(Location location) throws NoAvailableCars;

}
