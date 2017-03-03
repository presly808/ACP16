package utils;


import org.apache.log4j.Logger;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static utils.PropertyReader.*;

public class ManagerCreator {

    private static Logger LOG = Logger.getLogger(ManagerCreator.class);

    private EntityManagerFactory managerFactory;

    private ManagerCreator() {
        if (managerFactory == null) {
            this.managerFactory = Persistence.createEntityManagerFactory(getUnitName());
        }
    }

    private EntityManagerFactory getManagerFactory() {
        return managerFactory;
    }

    public static EntityManagerFactory getManager(){
        LOG.info("CREATE EntityManagerFactory ");
        return new ManagerCreator().getManagerFactory();
    }
}
