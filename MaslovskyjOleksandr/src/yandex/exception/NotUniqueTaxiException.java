package yandex.exception;

/**
 * Created by ubuntu on 02.02.17.
 */
public class NotUniqueTaxiException extends Exception {

    public NotUniqueTaxiException() {
        super("Taxi already present in service");
    }
}
