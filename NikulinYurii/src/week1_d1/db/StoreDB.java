package week1_d1.db;

import week1_d1.exeptions.InvalidIdExeption;
import week1_d1.exeptions.InvalidPiceExeption;
import week1_d1.exeptions.InvalidProductException;
import week1_d1.exeptions.InvalidTypeExeption;
import week1_d1.model.Product;
import week1_d1.model.ProductType;

import java.util.*;

/**
 * Created by yurii on 21.01.2017.
 */
public class StoreDB implements IStoreDB {
    private int productID = 0;
    private Map<Integer, Product> productMap;
    private int size = 0;

    public StoreDB() {
        productMap = new TreeMap<>();
    }

    @Override
    public Product addProduct(Product product) {
        size++;
        product.setProductId(productID);
        return productMap.put(productID++, product);
    }

    @Override
    public Product removeProduct(Product product) {
        size--;
        return productMap.remove(product.getProductId());
    }

    @Override
    public List<Product> allProduct() {
        List<Product> list = new ArrayList<>(productMap.size());

        for (Product i : productMap.values()
                ) {
            list.add(i);
        }

        return list;
    }

    @Override
    public List<Product> byPice(int pice) throws InvalidPiceExeption {
        if (pice < 0) throw new InvalidPiceExeption("Price must be more than 0");
        List<Product> list = new ArrayList<>();

        for (Product i : productMap.values()
                ) {

            if (i.getPice() == pice) {
                list.add(i);
            }

        }
        return list;
    }

    @Override
    public List<Product> byName(String name) throws InvalidProductException {
        List<Product> list = new ArrayList<>(productMap.size());

        for (Product i : productMap.values()
                ) {
            if (i.getName().equals(name)) {
                list.add(i);
            }
        }

        if (list.size() == 0) {
            throw new InvalidProductException("No product");
        } else {
            return list;
        }
    }

    @Override
    public List<Product> byType(ProductType type) throws InvalidTypeExeption {
        List<Product> list = new ArrayList<>(productMap.size());

        for (Product i : productMap.values()
                ) {
            if (i.getType() == type) {
                list.add(i);
            }
        }

        if (list.size() == 0) {
            throw new InvalidTypeExeption("Invalid product type");
        } else {
            return list;
        }
    }

    @Override
    public Product getByID(int id) throws InvalidIdExeption {
        Product produck = null;

        for (Product i : productMap.values()
                ) {
            if (i.getProductId() == id) {
                produck = i;
                break;
            }
        }
        if (produck==null) throw new InvalidIdExeption("incorekt id");
        return produck;
    }

    @Override
    public int getSizeDB() {
        return size;
    }
}
