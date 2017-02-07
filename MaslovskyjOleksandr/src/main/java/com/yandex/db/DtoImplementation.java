package com.yandex.db;

import com.yandex.controllers.IDto;
import com.yandex.exception.NoOrderFoundException;
import com.yandex.models.Order;
import com.yandex.models.Taxi;
import yandex.exception.NoTaxiFoundException;

import java.util.UUID;

public class DtoImplementation implements IDto {

    @Override
    public boolean saveOrderToDB(Order order) {
        return false;
    }

    @Override
    public boolean removeOrderFromDb(UUID id) throws NoOrderFoundException {
        return false;
    }

    @Override
    public boolean saveTaxiToDb(Taxi taxi) {
        return false;
    }

    @Override
    public boolean removeTaxiFromDB(UUID id) throws NoTaxiFoundException {
        return false;
    }
}
