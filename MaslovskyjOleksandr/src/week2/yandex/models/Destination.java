package week2.yandex.models;

/**
 * Created by oleksandr.maslovskyj on 2/1/2017.
 */
public class Destination {

    private double startPosition;

    private double endPosition;

    public Destination(double startPosition, double endPosition) {
        this.startPosition = startPosition;
        this.endPosition = endPosition;
    }

    public double getStartPosition() {
        return startPosition;
    }

    public void setStartPosition(double startPosition) {
        this.startPosition = startPosition;
    }

    public double getEndPosition() {
        return endPosition;
    }

    public void setEndPosition(double endPosition) {
        this.endPosition = endPosition;
    }
}
