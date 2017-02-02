package yandex.controllers;

import yandex.exception.NotValidPriceException;
import yandex.exception.WrongCoordinatesException;
import yandex.models.Location;

public interface IGenerateOrder {

    double calculateDistance(Location currentLocation, Location destination) throws WrongCoordinatesException;

    double calculatePrice() throws NotValidPriceException;
}
