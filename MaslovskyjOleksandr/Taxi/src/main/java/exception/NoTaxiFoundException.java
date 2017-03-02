package exception;

/**
 * Created by ubuntu on 07.02.17.
 */
public class NoTaxiFoundException extends Exception {

    public NoTaxiFoundException() {
        super("Taxi not found");
    }
}
