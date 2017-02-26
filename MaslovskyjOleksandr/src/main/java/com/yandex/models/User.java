package com.yandex.models;

import java.util.UUID;

public class User {

    private final UUID id;

    private String name;

    private String phone;

    public User(String name, String phone, UUID id) {
        this.name = name;
        this.phone = phone;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public UUID getId() {
        return id;
    }
}
