package store.controller;

import store.exceptions.ProductNotFoundException;
import store.model.Product;

import java.util.List;

public interface IStoreController {
    boolean addProduct(Product product);

    Product removeProduct(Product product);

    Product getProduct(String id) throws ProductNotFoundException;

    List<Product> filter(String filterBy, String value);

    List<Product> sort(String sortBy, String value);
}
