package store.view;

import store.exceptions.ProductNotFoundException;
import store.model.Product;

public interface IStoreView {
    //TODO: should it be method with parameters in method signature, should data creates in view's methods?
    boolean addProduct();

    Product removeProduct();

    Product getProduct() throws ProductNotFoundException;
}
