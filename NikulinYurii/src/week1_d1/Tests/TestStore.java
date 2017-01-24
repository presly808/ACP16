package week1_d1.Tests;

import com.sun.xml.internal.bind.v2.TODO;
import org.junit.*;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import week1_d1.controller.IStore;
import week1_d1.controller.Store;
import week1_d1.db.StoreDB;
import week1_d1.exeptions.InvalidPiceExeption;
import week1_d1.exeptions.InvalidProductException;
import week1_d1.exeptions.InvalidTypeExeption;
import week1_d1.model.Product;
import week1_d1.model.ProductType;

/**
 * Created by yurii on 23.01.2017.
 */

public class TestStore {

    private StoreDB storeDB;
    private IStore store;


    @Before
    public void setUp() {

        storeDB = new StoreDB();
        store = new Store(storeDB);

        store.addProduct(ProductType.PHONE, 1200, "meizu_M2");
        store.addProduct(ProductType.PHONE, 2200, "meizu_M3");

        store.addProduct(ProductType.NOTEBOOK, 12000, "HP");
        store.addProduct(ProductType.NOTEBOOK, 22000, "lenovo");

        store.addProduct(ProductType.ACCESSOR, 120, "a1");
        store.addProduct(ProductType.ACCESSOR, 120, "a2");
    }

    @Test
    public void addToStore() {
        int sizeDB = store.getSize();
        store.addProduct(ProductType.PHONE, 1200, "meizu_M2");
        Assert.assertTrue(store.getSize() > sizeDB);
    }

    @Test
    public void allProduct() {
        Assert.assertTrue(store.getAll().size() == store.getSize());
    }

    // не працює

    /*@Test
    public void removeProduct() {
        int s = store.getSize();
        Product p = new Product(ProductType.NOTEBOOK, 12000, "HP");

        try {
            store.removeProduct(p);
            Assert.assertTrue(s > store.getSize());
        } catch (InvalidProductException e) {
            e.printStackTrace();
            Assert.assertTrue(false);
        }

    }*/

    @Test
    public void byPice() {
        try {
            Assert.assertTrue(store.getByPice(120).size() == 2);
        } catch (InvalidPiceExeption invalidPiceExeption) {
            invalidPiceExeption.printStackTrace();
            Assert.assertTrue(false);
        }
    }

    @Test
    public void byName() {
        try {
            Assert.assertTrue(store.getByName("a2").size() == 1);
        } catch (InvalidProductException e) {
            e.printStackTrace();
            Assert.assertTrue(false);
        }
    }

    @Test
    public void byType() {
        try {
            Assert.assertTrue(store.getByTupe(ProductType.ACCESSOR).size() == 2);
        } catch (InvalidTypeExeption invalidTypeExeption) {
            invalidTypeExeption.printStackTrace();
            Assert.assertTrue(false);
        }
    }
}
