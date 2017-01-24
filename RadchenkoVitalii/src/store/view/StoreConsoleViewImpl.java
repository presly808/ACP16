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
    public void run() {
        int choice = -1;
        while (choice != 0){
            displayMainMenu();
            choice = userChoice();
            if (choice == 1){
                addProduct();
            } else if (choice == 2){
                getProduct();
            } else if (choice == 3){
                removeProduct();
            }
        }
    }

    @Override
    public void addProduct() {
        Product product = createProduct();
        boolean result = controller.addProduct(product);
        String addingResultMessage = result ? String.format("Done! Product was added. Product Id: %s\n", product.getId()) : "Error: Failed to add Product\n";
        System.out.println(addingResultMessage);
    }

    @Override
    public void removeProduct(){
        System.out.print("Enter product id: ");
        String id = consoleReader.enterLine();
        Product product;
        try {
            product = controller.getProduct(id);
            controller.removeProduct(product);
            System.out.println("Product was removed. Info:\n" + product + "\n");
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
            System.out.println("Product Info:\n" + product + "\n");
        } catch (ProductNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void filterProduct() {
        //TODO
    }

    @Override
    public void sortProduct() {
        //TODO
    }

    private Product createProduct() {
        System.out.println(CREATION_PRODUCT);

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

    private void displayMainMenu(){
            System.out.println("What would you like to do: \n1. Add product\n2. Get product\n3. Remove product\n0. Exit\n");
    }

    private int userChoice(){
        System.out.print("Please, make your choice: ");
        int choice = consoleReader.enterInteger();
        System.out.println("Danke!\n");
        return choice;
    }
}
