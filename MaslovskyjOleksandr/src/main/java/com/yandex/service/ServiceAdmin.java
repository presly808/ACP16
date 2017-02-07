package com.yandex.service;

import com.yandex.exception.NotUniqueTaxiException;
import com.yandex.models.Taxi;
import com.yandex.controllers.IServiceAdmin;

public class ServiceAdmin implements IServiceAdmin {

    //TODO after DB
    @Override
    public Taxi addTaxiToService(Taxi taxi) throws NotUniqueTaxiException {
        return null;
    }
}
