package com.yandex.service;

import com.yandex.exception.NotUniqueTaxiException;
import com.yandex.models.Taxi;
import com.yandex.controllers.IServiceAdmin;

/**
 * Created by ubuntu on 02.02.17.
 */
public class ServiceAdmin implements IServiceAdmin {
    @Override
    public Taxi addTaxiToService(Taxi taxi) throws NotUniqueTaxiException {
        return null;
    }
}
