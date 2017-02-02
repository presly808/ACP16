package yandex.controllers;

import yandex.exception.NoAvailableCarsException;
import yandex.exception.NoOrderFoundException;
import yandex.exception.NotValidPriceException;
import yandex.exception.WrongCoordinatesException;
import yandex.models.Client;
import yandex.models.Location;
import yandex.models.Order;
import yandex.models.Taxi;

import java.util.List;
import java.util.Optional;

public interface IServiceClient {

    Order makeOrder(Location currentLocation, Location destination) throws NoAvailableCarsException, NotValidPriceException, WrongCoordinatesException;

    List<Taxi> showTaxiList() throws NoAvailableCarsException;

    boolean cancelOrder(Order order) throws NoOrderFoundException;

    Taxi findFreeTaxi(Location location) throws NoAvailableCarsException;
}
