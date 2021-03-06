package com.yandex.controllers;

import com.yandex.exception.NoAvailableCarsException;
import com.yandex.exception.NoOrderFoundException;
import com.yandex.exception.NotValidPriceException;
import com.yandex.exception.WrongCoordinatesException;
import com.yandex.models.Location;
import com.yandex.models.Order;
import com.yandex.models.Taxi;

import java.util.List;
import java.util.Optional;

public interface IServiceClient {

    Order makeOrder(Location currentLocation, Location destination) throws NoAvailableCarsException, NotValidPriceException, WrongCoordinatesException;

    boolean confirmOrder() throws NoOrderFoundException;

    List<Taxi> showTaxiList() throws NoAvailableCarsException;

    boolean cancelOrder(Order order) throws NoOrderFoundException;

    Optional<Taxi> findFreeTaxi(Location location) throws NoAvailableCarsException;
}
