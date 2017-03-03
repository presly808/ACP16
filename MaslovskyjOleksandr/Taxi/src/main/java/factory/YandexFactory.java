package factory;


import dao.ILocation;
import dao.IServiceAdmin;
import dao.IServiceClient;
import exception.NotValidAdminPasswordException;
import service.ServiceAdmin;
import service.ServiceClient;
import service.ServiceLocation;

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
