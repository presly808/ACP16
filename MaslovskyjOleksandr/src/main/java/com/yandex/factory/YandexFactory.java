package com.yandex.factory;


import com.yandex.controllers.ILocation;
import com.yandex.controllers.IServiceAdmin;
import com.yandex.controllers.IServiceClient;
import com.yandex.service.ServiceAdmin;
import com.yandex.service.ServiceClient;
import com.yandex.service.ServiceLocation;
import yandex.exception.NotValidAdminPasswordException;

public class YandexFactory {

    public IServiceClient iServiceClient;
    public IServiceAdmin iServiceAdmin;
    public ILocation iLocation;

    private final String ADMIN_PASS = "password";

    public YandexFactory() {
        this.iServiceClient = new ServiceClient();
        this.iLocation = new ServiceLocation();
    }

    public YandexFactory(String password) throws NotValidAdminPasswordException {
        if (passwordValidation(password)) {
            this.iServiceAdmin = new ServiceAdmin();
            this.iLocation = new ServiceLocation();
        }
        throw new NotValidAdminPasswordException();
    }

    private boolean passwordValidation(String pass){
        return pass.equals(ADMIN_PASS);
    }
}
