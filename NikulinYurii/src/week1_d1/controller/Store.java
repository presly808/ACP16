package week1_d1.controller;

import week1_d1.db.IStoreDB;
import week1_d1.db.StoreDB;
import week1_d1.exeptions.InvalidIdExeption;
import week1_d1.exeptions.InvalidPiceExeption;
import week1_d1.exeptions.InvalidProductException;
import week1_d1.exeptions.InvalidTypeExeption;
import week1_d1.model.Product;
import week1_d1.model.ProductType;

import java.util.List;

/**
 * Created by yurii on 21.01.2017.
 */
public class Store implements IStore {

    private IStoreDB storeDB;

    public Store(IStoreDB storeDB) {
        this.storeDB = storeDB;
    }

    @Override
    public Product addProduct(ProductType tupe, int pice, String name) {

        Product product = new Product(tupe, pice, name);


        return storeDB.addProduct(product);
    }

    @Override
    public Product removeProduct(Product product) throws InvalidProductException {

        return storeDB.removeProduct(product);
    }

    @Override
    public List<Product> getByPice(int pise) throws InvalidPiceExeption {
        return storeDB.byPice(pise);
    }

    @Override
    public List<Product> getByName(String name) throws InvalidProductException {
        return storeDB.byName(name);
    }

    @Override
    public List<Product> getByTupe(ProductType type) throws InvalidTypeExeption {
        return storeDB.byType(type);
    }

    @Override
    public List<Product> getAll() {

        return storeDB.allProduct();
    }

    public int getSize() {
        return storeDB.getSizeDB();
    }

    @Override
    public Product getById(int id) throws InvalidIdExeption {
        return storeDB.getByID(id);
    }
}
