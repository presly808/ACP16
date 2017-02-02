package yandex.controllers;

import yandex.exception.NotValidPriceException;
import yandex.exception.WrongCoordinatesException;
import yandex.models.Location;

/**
 * Created by ubuntu on 02.02.17.
 */
public interface ILocation {

    double calculateDistance(Location current, Location destination) throws WrongCoordinatesException;

    double calculatePrice(Location current, Location destination) throws NotValidPriceException, WrongCoordinatesException;

}
