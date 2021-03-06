package com.yandex.controllers;

import com.yandex.exception.DbNotAvailableException;

import java.util.List;

public interface IQuery {

    boolean insertInto(String tableName, List<String> param) throws DbNotAvailableException;

    String selectFrom(String tableName, List<String> param) throws DbNotAvailableException;
}
