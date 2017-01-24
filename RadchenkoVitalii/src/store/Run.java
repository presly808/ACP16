package store;

import store.controller.IStoreController;
import store.controller.StoreControllerImpl;
import store.model.Product;
import store.view.IStoreView;
import store.view.StoreConsoleViewImpl;

import java.util.ArrayList;
import java.util.List;

public class Run {
    public static void main(String[] args){
        List<Product> products = getFromDB();
        IStoreController controller = new StoreControllerImpl(products);
        IStoreView applicationView = new  StoreConsoleViewImpl(controller);

        applicationView.run();
    }

    public static List<Product> getFromDB(){
        return new ArrayList<>();
    } //TODO: read from jsons, serilization
}
