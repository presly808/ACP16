package com.weather.exceptions;

/**
 * Created by ubuntu on 13.02.17.
 */
public class NoServerFoundException extends Exception {
    public NoServerFoundException() {
        super("Server not found");
    }
}
