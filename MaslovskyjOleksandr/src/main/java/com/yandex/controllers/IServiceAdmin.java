package com.yandex.controllers;

import com.yandex.exception.NotUniqueTaxiException;
import com.yandex.models.Taxi;

/**
 * Created by ubuntu on 02.02.17.
 */
public interface IServiceAdmin {

    Taxi addTaxiToService(Taxi taxi) throws NotUniqueTaxiException;

}
