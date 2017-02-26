package com.yandex.exception;

/**
 * Created by ubuntu on 31.01.17.
 */
public class NoAvailableCarsException extends Exception {

    public NoAvailableCarsException() {
        super("Sorry... No free taxi");
    }
}
