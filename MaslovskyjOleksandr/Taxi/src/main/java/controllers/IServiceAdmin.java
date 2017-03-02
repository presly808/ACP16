package controllers;


import exception.NotUniqueTaxiException;
import models.Taxi;

/**
 * Created by ubuntu on 02.02.17.
 */
public interface IServiceAdmin {

    Taxi addTaxiToService(Taxi taxi) throws NotUniqueTaxiException;

}
