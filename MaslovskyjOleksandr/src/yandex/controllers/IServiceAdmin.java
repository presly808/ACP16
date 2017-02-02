package yandex.controllers;

import yandex.exception.NotUniqueTaxiException;
import yandex.models.Taxi;

/**
 * Created by ubuntu on 02.02.17.
 */
public interface IServiceAdmin {

    Taxi addTaxiToService(Taxi taxi) throws NotUniqueTaxiException;

}
