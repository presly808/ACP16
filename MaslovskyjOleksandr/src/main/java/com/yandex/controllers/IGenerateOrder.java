package com.yandex.controllers;

import com.yandex.exception.NotValidPriceException;
import com.yandex.exception.WrongCoordinatesException;
import com.yandex.models.Location;

public interface IGenerateOrder {

    double calculateDistance(Location currentLocation, Location destination) throws WrongCoordinatesException;

    double calculatePrice() throws NotValidPriceException;
}
