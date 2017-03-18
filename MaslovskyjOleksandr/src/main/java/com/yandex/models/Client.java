package com.yandex.models;

import java.util.UUID;


public class Client extends User {

    public Client(String name, String phone, UUID id) {
        super(name, phone, id);
    }
}
