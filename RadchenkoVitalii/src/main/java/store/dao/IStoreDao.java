package store.dao;

import store.model.Product;

import java.util.Collection;

public interface IStoreDao {
    Collection<Product> getAllProducts();

    boolean saveProducts(Collection<Product> products);
}
