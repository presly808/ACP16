package controllers;


import exception.NoAvailableCarsException;
import exception.NoOrderFoundException;
import exception.NotValidPriceException;
import exception.WrongCoordinatesException;
import models.Location;
import models.Order;
import models.Taxi;

import java.util.List;
import java.util.Optional;

public interface IServiceClient {

    Order makeOrder(Location currentLocation, Location destination) throws NoAvailableCarsException, NotValidPriceException, WrongCoordinatesException;

    boolean confirmOrder() throws NoOrderFoundException;

    List<Taxi> showTaxiList() throws NoAvailableCarsException;

    boolean cancelOrder(Order order) throws NoOrderFoundException;

    Optional<Taxi> findFreeTaxi(Location location) throws NoAvailableCarsException;
}
