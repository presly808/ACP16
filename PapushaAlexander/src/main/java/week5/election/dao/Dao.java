package week5.election.dao;

import java.util.List;

/**
 * Created by alex on 03.03.17.
 */
public interface Dao<T,ID> {

    T create(T entity);
    List<T> getAll(int offset, int length);
    T findOne(ID id);
    T delete(ID id);

}
