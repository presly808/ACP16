package yandex.controllers;

import yandex.exception.NotValidPriceException;
import yandex.exception.WrongCoordinatesException;
import yandex.models.CurrentLocation;
import yandex.models.Destination;

public interface IGenerateOrder {

    double calculateDistance(CurrentLocation currentLocation, Destination destination) throws WrongCoordinatesException;

    double calculatePrice() throws NotValidPriceException;
}
