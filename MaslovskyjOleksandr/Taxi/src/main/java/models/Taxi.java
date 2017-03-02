package models;

import controllers.ILocation;

/**
 * Created by ubuntu on 31.01.17.
 */
public class Taxi {

    private User owner;
    private CarModels carModel;
    private boolean busy;
    private ILocation currentLocation;

    public Taxi(User owner, CarModels carModel, boolean busy, ILocation currentLocation) {
        this.owner = owner;
        this.carModel = carModel;
        this.busy = busy;
        this.currentLocation = currentLocation;
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

    public ILocation getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(ILocation currentLocation) {
        this.currentLocation = currentLocation;
    }
}
