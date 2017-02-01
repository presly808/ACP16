package week2.yandex.models;

/**
 * Created by ubuntu on 31.01.17.
 */
public class Location {

    private CurrentLocation currentLocation;

    private Destination destinationLocation;

    public Location(CurrentLocation currecntLocation, Destination destination) {
        this.currentLocation = currecntLocation;
        this.destinationLocation = destination;
    }

    public CurrentLocation getCurrectLocation() {
        return currentLocation;
    }

    public void setCurrectLocation(CurrentLocation currectLocation) {
        this.currentLocation = currectLocation;
    }

    public Destination getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(Destination destinationLocation) {
        this.destinationLocation = destinationLocation;
    }
}
