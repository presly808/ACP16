package dao;


import exceptions.InvalidInputObjectException;
import exceptions.NoObjectFoundException;
import exceptions.NotAvailableTableException;

import java.util.List;

public interface Dao<T> {

    boolean insertIntoTable(T object) throws NotAvailableTableException;

    T getObjectFromTable(long id) throws InvalidInputObjectException;

    List<T> showAllObjects() throws NoObjectFoundException;

}
