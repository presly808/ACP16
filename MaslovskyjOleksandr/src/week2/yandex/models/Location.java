package week2.yandex.models;

/**
 * Created by ubuntu on 31.01.17.
 */
public class Location {

    private double startLongitude;

    private double endLongitude;

    private double startLatitude;

    private double endLatitude;

    public Location(double startLongitude, double endLongitude, double startLatitude, double endLatitude) {
        this.startLongitude = startLongitude;
        this.endLongitude = endLongitude;
        this.startLatitude = startLatitude;
        this.endLatitude = endLatitude;
    }

    public double getStartLongitude() {
        return startLongitude;
    }

    public void setStartLongitude(double startLongitude) {
        this.startLongitude = startLongitude;
    }

    public double getEndLongitude() {
        return endLongitude;
    }

    public void setEndLongitude(double endLongitude) {
        this.endLongitude = endLongitude;
    }

    public double getStartLatitude() {
        return startLatitude;
    }

    public void setStartLatitude(double startLatitude) {
        this.startLatitude = startLatitude;
    }

    public double getEndLatitude() {
        return endLatitude;
    }

    public void setEndLatitude(double endLatitude) {
        this.endLatitude = endLatitude;
    }
}
