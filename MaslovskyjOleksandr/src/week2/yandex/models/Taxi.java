package week2.yandex.models;

/**
 * Created by ubuntu on 31.01.17.
 */
public class Taxi {

    private User owner;

    private CarModels carModel;

    private boolean busy;

    public Taxi(User owner, CarModels carModel, boolean busy) {
        this.owner = owner;
        this.carModel = carModel;
        this.busy = busy;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public CarModels getCarModel() {
        return carModel;
    }

    public void setCarModel(CarModels carModel) {
        this.carModel = carModel;
    }

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }
}
