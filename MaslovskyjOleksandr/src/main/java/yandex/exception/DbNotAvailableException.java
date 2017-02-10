package yandex.exception;

/**
 * Created by ubuntu on 10.02.17.
 */
public class DbNotAvailableException extends Exception {

    public DbNotAvailableException() {
        super("DataBase not available");
    }
}
