package service;

import exception.NotUniqueTaxiException;
import models.Taxi;
import dao.IServiceAdmin;

public class ServiceAdmin implements IServiceAdmin {

    //TODO after DB
    @Override
    public Taxi addTaxiToService(Taxi taxi) throws NotUniqueTaxiException {
        return null;
    }
}
