package store.view;

import store.controller.IStoreController;
import store.model.Product;

import java.util.List;

public class StoreViewImpl implements IStoreView {
    private IStoreController controller;
    private List<Product> products;

    public StoreViewImpl(IStoreController controller, List<Product> products){
        this.controller = controller;
        this.products = products;
    }
}
