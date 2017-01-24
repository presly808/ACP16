package store.view;

import store.controller.IStoreController;
import store.enums.ProductField;
import store.enums.ProductType;
import store.exceptions.ProductNotFoundException;
import store.model.Product;
import store.utils.ConsoleReader;

import static store.Messages.CREATION_PRODUCT;

public class StoreConsoleViewImpl implements IStoreView {
    private IStoreController controller;
    private ConsoleReader consoleReader;

    public StoreConsoleViewImpl(IStoreController controller){
        this.controller = controller;
        consoleReader = new ConsoleReader();
    }

    @Override
    public int displayMenu() {
        System.out.println("What would you like to do: ");
        System.out.println("1. Add product");
        System.out.println("2. Get product");
        System.out.println("3. Remove product");
        return consoleReader.enterInteger();
    }

    @Override
    public boolean addProduct() {
        Product product = createProduct();
        return controller.addProduct(product);
    }

    @Override
    public void removeProduct(){
        System.out.print("Enter product id: ");
        String id = consoleReader.enterLine();
        Product product;
        try {
            product = controller.getProduct(id);
            controller.removeProduct(product);
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void getProduct() {
        System.out.print("Enter product id: ");
        String id = consoleReader.enterLine();
        Product product;
        try {
            product = controller.getProduct(id);
            System.out.println(product);
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }


    private Product createProduct() {
        System.out.println(CREATION_PRODUCT);
        //ProductField.displayCreationField();

        String name = enterData(1, ProductField.Name);// consoleReader.enterLine();
        Double price = Double.parseDouble(enterData(2, ProductField.Price)); //consoleReader.enterDouble();
        String description = enterData(3, ProductField.Description); //consoleReader.enterLine();
        String typeAsString = enterData(4, ProductField.Type); //consoleReader.enterLine();
        ProductType productType = ProductType.valueOf(typeAsString);

        return new Product(name, price, description, productType);
    }

    //TODO: rename
    private String enterData(int index, ProductField field){
        System.out.print(String.format("%d. %s: ", index, field.name()));
        return consoleReader.enterLine();
    }
}
