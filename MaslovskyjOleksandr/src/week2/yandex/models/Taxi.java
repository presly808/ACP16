package week2.yandex.models;

/**
 * Created by ubuntu on 31.01.17.
 */
public class Taxi {

    private User owner;

    private CarModels carModel;

    public Taxi(User owner, CarModels carModel) {
        this.owner = owner;
        this.carModel = carModel;
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
}
