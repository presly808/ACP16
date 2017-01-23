package store.view;

import store.controller.IStoreController;
import store.enums.ProductField;
import store.enums.ProductType;
import store.exceptions.ProductNotFoundException;
import store.model.Product;
import store.utils.ConsoleReader;

import java.util.List;

import static store.Messages.CREATION_PRODUCT;

public class StoreConsoleViewImpl implements IStoreView {
    private IStoreController controller;
    private List<Product> products;
    private ConsoleReader consoleReader;

    public StoreConsoleViewImpl(IStoreController controller, List<Product> products){
        this.controller = controller;
        this.products = products;
        consoleReader = new ConsoleReader();
    }

    @Override
    public boolean addProduct() {
        Product product = createProduct();
        return controller.addProduct(product);
    }

    @Override
    public Product removeProduct(){
        return null;
    }

    @Override
    public Product getProduct() throws ProductNotFoundException {
        return null;
    }


    private Product createProduct() {
        System.out.println(CREATION_PRODUCT);
        ProductField.displayCreationField();
        String name = consoleReader.enterLine();
        Double price = consoleReader.enterDouble();
        String description = consoleReader.enterLine();
        String typeAsString = consoleReader.enterLine();
        ProductType type = ProductType.valueOf(typeAsString);

        return null; //TODO
    }


}
