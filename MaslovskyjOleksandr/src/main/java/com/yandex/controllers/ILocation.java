package com.yandex.controllers;

import com.yandex.exception.NotValidPriceException;
import com.yandex.exception.WrongCoordinatesException;
import com.yandex.models.Location;

/**
 * Created by ubuntu on 02.02.17.
 */
public interface ILocation {

    double calculateDistance(Location current, Location destination) throws WrongCoordinatesException;

    double calculatePrice(Location current, Location destination) throws NotValidPriceException, WrongCoordinatesException;

}
