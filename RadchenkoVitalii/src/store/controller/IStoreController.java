package store.controller;

import store.exceptions.ProductNotFoundException;
import store.model.Product;

public interface IStoreController {
    boolean addProduct(Product product);

    Product removeProduct(Product product);

    Product getProduct(String id) throws ProductNotFoundException;
}
