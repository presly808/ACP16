package yandex.service;

import yandex.controllers.ILocation;
import yandex.exception.NotValidPriceException;
import yandex.exception.WrongCoordinatesException;
import yandex.models.Location;

public class ServiceLocation implements ILocation {

    private final double EARTH_RADIUS = 6371000;
    private final double TARIF = 20.4;

    @Override
    public double calculatePrice(Location current, Location destination) throws NotValidPriceException, WrongCoordinatesException {
        double distance = calculateDistance(current, destination);
        return distance / 1000 * TARIF;
    }

    @Override
    public double calculateDistance(Location current, Location destination) throws WrongCoordinatesException {
        double dLat = Math.toRadians(destination.getX() - current.getX());
        double dLng = Math.toRadians(destination.getY() - current.getY());
        double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
                Math.cos(Math.toRadians(current.getX())) * Math.cos(Math.toRadians(destination.getX())) *
                        Math.sin(dLng/2) * Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        return (float) (EARTH_RADIUS * c);
    }
}
