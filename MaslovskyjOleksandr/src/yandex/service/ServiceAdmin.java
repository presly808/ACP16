package yandex.service;

import yandex.controllers.IServiceAdmin;
import yandex.exception.NotUniqueTaxiException;
import yandex.models.Taxi;

/**
 * Created by ubuntu on 02.02.17.
 */
public class ServiceAdmin implements IServiceAdmin {
    @Override
    public Taxi addTaxiToService(Taxi taxi) throws NotUniqueTaxiException {
        return null;
    }
}
