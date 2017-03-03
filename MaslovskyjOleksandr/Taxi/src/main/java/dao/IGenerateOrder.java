package dao;


import exception.NotValidPriceException;
import exception.WrongCoordinatesException;
import models.Location;

public interface IGenerateOrder {

    double calculateDistance(Location currentLocation, Location destination) throws WrongCoordinatesException;

    double calculatePrice() throws NotValidPriceException;
}
