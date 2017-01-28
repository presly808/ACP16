package week1_d1.db;

import week1_d1.exeptions.InvalidIdExeption;
import week1_d1.exeptions.InvalidPiceExeption;
import week1_d1.exeptions.InvalidProductException;
import week1_d1.exeptions.InvalidTypeExeption;
import week1_d1.model.Product;
import week1_d1.model.ProductType;

import java.util.List;

/**
 * Created by yurii on 24.01.2017.
 */
public interface IStoreDB {
    Product addProduct(Product product);

    Product removeProduct(Product product);

    List<Product> allProduct();

    List<Product> byPice(int pice) throws InvalidPiceExeption;

    List<Product> byName(String name) throws InvalidProductException;

    List<Product> byType(ProductType type) throws InvalidTypeExeption;

    Product getByID(int id) throws InvalidIdExeption;

    int getSizeDB();
}
