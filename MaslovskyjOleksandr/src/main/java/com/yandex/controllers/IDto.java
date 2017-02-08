package com.yandex.controllers;

import com.yandex.exception.NoOrderFoundException;
import com.yandex.models.Order;
import com.yandex.models.Taxi;
import com.yandex.exception.NoTaxiFoundException;

import java.util.UUID;

public interface IDto {

    boolean saveOrderToDB(Order order);

    boolean removeOrderFromDb(UUID id) throws NoOrderFoundException;

    boolean saveTaxiToDb(Taxi taxi);

    boolean removeTaxiFromDB(UUID id) throws NoTaxiFoundException;
}
