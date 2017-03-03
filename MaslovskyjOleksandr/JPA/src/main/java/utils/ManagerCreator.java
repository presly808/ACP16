package utils;


import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NamedQuery;
import javax.persistence.Persistence;

import static utils.PropertyReader.*;

@NamedQuery(name="Assignment.findAll", query ="SELECT * FROM candidates")
public class ManagerCreator {

    private static Logger LOG = Logger.getLogger(ManagerCreator.class);

    private EntityManagerFactory managerFactory;

    private ManagerCreator() {
        if (managerFactory == null) {
            this.managerFactory = Persistence.createEntityManagerFactory(getUnitName());
        }
    }

    public static EntityManager getManager(){
        LOG.info("CREATE EntityManagerFactory ");
        return new ManagerCreator().managerFactory.createEntityManager();
    }
}
