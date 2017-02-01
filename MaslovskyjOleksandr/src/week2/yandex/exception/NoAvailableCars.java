package week2.yandex.exception;

/**
 * Created by ubuntu on 31.01.17.
 */
public class NoAvailableCars extends Exception {

    public NoAvailableCars() {
        super("Sorry... No free taxi");
    }
}
