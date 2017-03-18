package com.yandex.exception;

public class NoOrderFoundException extends Exception {

    public NoOrderFoundException() {
        super("No order found");
    }
}
