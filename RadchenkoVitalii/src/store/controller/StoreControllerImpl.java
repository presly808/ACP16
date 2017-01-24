package store.controller;

import store.exceptions.ProductNotFoundException;
import store.model.Product;

import java.util.List;
import java.util.NoSuchElementException;

import static store.Messages.NOT_FOUND_PRODUCT_BY_ID;

public class StoreControllerImpl implements IStoreController {
    private List<Product> productList; // TODO: replace by set?

    public StoreControllerImpl(List<Product> productList){
        this.productList = productList;
    }

    @Override//TODO: where data checks should be?
    public boolean addProduct(Product product) {
        if (isValid(product)){ //some validation
            return productList.add(product);
        }
        return false;
    }

    @Override//TODO: no validation here for a product
    public Product removeProduct(Product product){
        productList.remove(product);
        return product;
    }

    @Override
    public Product getProduct(String id) throws ProductNotFoundException {
        try {
            Product foundedProduct = productList.stream().filter(product -> product.getId().equals(id)).findFirst().get();
            return foundedProduct;
        } catch (NoSuchElementException e){
            throw new ProductNotFoundException(String.format(NOT_FOUND_PRODUCT_BY_ID, id));
        }
    }

    private static boolean isValid(Product product){
        if (product != null && product.getId() != null)
            return true;
        return false;
    }
}
