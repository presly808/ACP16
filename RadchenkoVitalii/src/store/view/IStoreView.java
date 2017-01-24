package store.view;

public interface IStoreView {
    int displayMenu();

    //TODO: should it be method with parameters in method signature, should data creates in view's methods?
    boolean addProduct();

    void removeProduct();

    void getProduct();
}
