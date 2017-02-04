package com.yandex.models;

import java.util.UUID;

/**
 * Created by ubuntu on 31.01.17.
 */
public class Client extends User {

    public Client(String name, String phone, UUID id) {
        super(name, phone, id);
    }
}
