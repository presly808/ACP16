package dao;


import exception.NotValidPriceException;
import exception.WrongCoordinatesException;
import models.Location;

/**
 * Created by ubuntu on 02.02.17.
 */
public interface ILocation {

    double calculateDistance(Location current, Location destination) throws WrongCoordinatesException;

    double calculatePrice(Location current, Location destination) throws NotValidPriceException, WrongCoordinatesException;

}
