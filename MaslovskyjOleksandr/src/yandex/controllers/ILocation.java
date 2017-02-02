package yandex.controllers;

import yandex.exception.WrongCoordinatesException;

/**
 * Created by ubuntu on 02.02.17.
 */
public interface ILocation {

    double getLatitude(double x) throws WrongCoordinatesException;

    double getLongitude(double y) throws WrongCoordinatesException;

}
