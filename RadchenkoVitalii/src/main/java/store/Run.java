package store;

import com.fasterxml.jackson.databind.ObjectMapper;
import store.controller.IStoreController;
import store.controller.StoreControllerImpl;
import store.enums.ProductType;
import store.model.MobilePhone;
import store.model.Product;
import store.utils.StringUtils;
import store.view.storeView.IStoreView;
import store.view.storeView.StoreConsoleViewImpl;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Run {
    public static void main(String[] args) throws IOException {
        saveInDB();
        List<Product> products = getFromDB();
        IStoreController controller = new StoreControllerImpl(products);
        IStoreView applicationView = new  StoreConsoleViewImpl(controller);

        applicationView.run();
    }

    public static List<Product> getFromDB() throws IOException {
        ObjectMapper mapper = new ObjectMapper();

        String jsonAsString = StringUtils.loadFileIntoString("products.json");
        List<Product> products = mapper.readValue(jsonAsString, mapper.getTypeFactory().constructCollectionType(List.class, Product.class));

        return products;
    }

    public static void saveInDB() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Product samsung = new Product("Samsung", 10d, "Desc", ProductType.Phone);
        Product htc = new Product("HTC", 20d, "Desc", ProductType.Phone);
        Product laptop = new Product("HP", 100d, "laptop", ProductType.Laptop);
        Product phoneClass = new MobilePhone("HP", 100d, "laptop", 5);

        List<Product> collections = Arrays.asList(samsung, htc, laptop);

        mapper.writeValue(new File("products.json"), collections);
    }

}
