package com.yandex.exception;


public class NotValidAdminPasswordException extends Exception{

    public NotValidAdminPasswordException() {
        super("Not valid admin password");
    }
}
