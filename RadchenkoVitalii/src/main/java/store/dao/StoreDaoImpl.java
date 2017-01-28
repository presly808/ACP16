package store.dao;

import com.fasterxml.jackson.databind.ObjectMapper;
import store.model.Laptop;
import store.model.MobilePhone;
import store.model.Product;
import store.utils.PropertyReader;
import store.utils.StringUtils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.*;

public class StoreDaoImpl implements IStoreDao {

    public Set<Product> getAllProducts() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String phonesFilePath = PropertyReader.readProperty("db.phones.path");
        String laptopsFilePath = PropertyReader.readProperty("db.laptops.path"); // TODO: readPropertyWorks bad

        String jsonPhoneAsString = StringUtils.loadFileIntoString(phonesFilePath);
        String jsonLaptopAsString = StringUtils.loadFileIntoString(laptopsFilePath);
        List<MobilePhone> phones = mapper.readValue(jsonPhoneAsString, mapper.getTypeFactory().constructCollectionType(List.class, MobilePhone.class));
        List<Laptop> laptops = mapper.readValue(jsonLaptopAsString, mapper.getTypeFactory().constructCollectionType(List.class, Laptop.class));

        Set<Product> products = new HashSet<>();
        products.addAll(phones);
        products.addAll(laptops);

        return products;
    }

    public boolean saveProducts(Collection<Product> products) {
        return false; //TODO
    }

    public static void createFakeDbData() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        MobilePhone samsung = new MobilePhone("Samsung", 10d, "Desc", 4);
        MobilePhone htc = new MobilePhone("HTC", 20d, "Desc", 4);
        Laptop laptopHp = new Laptop("HP", 100d, "laptop", 500);
        Laptop laptopLenovo = new Laptop("Lenovo", 79d, "laptop", 486);

        List<MobilePhone> phones = Arrays.asList(samsung, htc);
        List<Laptop> laptops = Arrays.asList(laptopHp, laptopLenovo);

        mapper.writeValue(new File(Paths.get("RadchenkoVitalii", "src", "resources", "data", "phone.json").toString()), phones);
        mapper.writeValue(new File(Paths.get("RadchenkoVitalii", "src", "resources", "data", "laptop.json").toString()), laptops);
    }
}
