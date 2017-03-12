package utils;


import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;

import static utils.PropertyReader.*;

public class ManagerCreator {

    private static Logger LOG = Logger.getLogger(ManagerCreator.class);
    private static EntityManager managerFactory;

    private ManagerCreator() {
        if (managerFactory == null) {
            managerFactory = Persistence.createEntityManagerFactory(getUnitName()).createEntityManager();
        }
    }

    public static EntityManager getManager(){
        LOG.info("CREATE EntityManagerFactory ");
        return new ManagerCreator().managerFactory;
    }
}
