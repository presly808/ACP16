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
    private ConsoleReader consoleReader;

    public StoreConsoleViewImpl(IStoreController controller){
        this.controller = controller;
        consoleReader = new ConsoleReader();
    }

    @Override
    public void run() {
        int choice = -1;
        boolean display = true;
        while (choice != 0) {
            if (display)
                displayMainMenu();
            choice = userChoice();
            switch (choice) {
                case 1:
                    addProduct();
                    display = true;
                    break;
                case 2:
                    getProduct();
                    display = true;
                    break;
                case 3:
                    removeProduct();
                    display = true;
                    break;
                case 4:
                    filterByPriceRange();
                    display = true;
                    break;
                case 5:
                    filterByName();
                    display = true;
                    break;
                case 6:
                    sortProduct();
                    display = true;
                    break;
                case 0:
                    System.out.println("Session is end. Thank you for using VR IT technologies solutions.");
                    break;
                default:
                    System.out.println("Error: Unknown command.\n");
                    display = false;
                    break;
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
    public void filterByPriceRange() {
        System.out.print("Enter start price: ");
        Double startPrice = consoleReader.enterDouble();
        System.out.print("Enter final price: ");
        Double finalPrice = consoleReader.enterDouble();

        List<Product> filtered = controller.filterByPriceRange(startPrice, finalPrice);
        System.out.println("Filter Result: ");
        filtered.stream().forEach(System.out::println);
        System.out.println();
    }

    @Override
    public void filterByName() {
        System.out.print("Enter product name to filter by: ");
        String name = consoleReader.enterLine();
        List<Product> filtered = controller.filterByName(name);
        System.out.println("Result: ");
        filtered.stream().forEach(System.out::println);
    }

    @Override
    public void sortProduct() {
        displaySortMenu();
        System.out.print("Enter value: ");
        int choice = consoleReader.enterInteger();
        List<Product> sorted = null;

        switch (choice){
            case 1:
                sorted = controller.sort(ProductField.Name);
                break;
            case 2:
                sorted = controller.sort(ProductField.Price);
                break;
            default:
                System.out.print("Error. Unknown sort option.\n");
        }
        System.out.println("Sorting result: ");
        sorted.stream().forEach(System.out::println);
        System.out.println();
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
            System.out.println("What would you like to do: \n1. Add product\n2. Get product\n3. Remove product\n" +
                    "4. Filter by Price\n5. Filter by Name\n6. Sort Menu\n0. Exit\n");
    }

    private void displaySortMenu(){
        System.out.println("Choose field that you would like sort by:\n1. Name\n2. Price");
    }

    private int userChoice(){
        System.out.print("Please, make your choice: ");
        int choice = consoleReader.enterInteger();
        System.out.println("Danke!\n");
        return choice;
    }
}
