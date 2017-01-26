package store.dao;

import store.model.Product;
import store.utils.PropertyReader;

import java.util.Collection;

public class StoreDaoImpl implements IStoreDao {
    private final String dataPath = PropertyReader.readProperty("db");

    public Collection<Product> getAllProducts() {
        return null;
    }

    public boolean saveProducts(Collection<Product> products) {
        return false;
    }
}
