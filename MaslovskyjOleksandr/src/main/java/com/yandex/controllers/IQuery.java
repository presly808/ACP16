package com.yandex.controllers;

import com.yandex.exception.NoOrderFoundException;
import com.yandex.models.Order;
import com.yandex.models.Taxi;
import com.yandex.exception.NoTaxiFoundException;
import yandex.exception.DbNotAvailableException;

import java.util.List;
import java.util.UUID;

public interface IQuery {

    boolean insertInto(String tableName, List<String> param) throws DbNotAvailableException;

    String selectFrom(String tableName, List<String> param) throws DbNotAvailableException;
}
