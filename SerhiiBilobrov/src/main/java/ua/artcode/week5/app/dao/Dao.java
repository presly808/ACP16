package ua.artcode.week5.app.dao;

import java.util.List;

/**
 * Created by serhii on 26.02.17.
 */
public interface Dao<T,ID> {

    T create(T entity);
    List<T> getAll(int offset, int length);
    T findOne(ID id);
    T delete(ID id);

}
