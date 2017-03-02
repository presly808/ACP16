package week1_d1.controller;

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
public interface IStore {


    Product addProduct(ProductType tupe, int pice, String name);

    Product removeProduct(Product product) throws InvalidProductException;

    List<Product> getByPice(int pise) throws InvalidPiceExeption;

    List<Product> getByName(String name) throws InvalidProductException;

    List<Product> getByTupe(ProductType type) throws InvalidTypeExeption;

    List<Product> getAll();


    int getSize();

    Product getById(int id) throws InvalidIdExeption;
}
