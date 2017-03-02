import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
        Persistence.createEntityManagerFactory("hibernate-unit");
    }

}
