package week6.election.entityManager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by alex on 23.03.17.
 */

public class Manager {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager manager;
    private EntityTransaction transaction;

    public Manager() {
    }

    public Manager(String name) {
        this.entityManagerFactory = Persistence.createEntityManagerFactory(name);
        this.manager = entityManagerFactory.createEntityManager();
        this.transaction = manager.getTransaction();
    }

    public EntityManagerFactory getEntityManagerFactory() {
        return entityManagerFactory;
    }

    public void setEntityManagerFactory(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    public EntityTransaction getTransaction() {
        return transaction;
    }

    public void setTransaction(EntityTransaction transaction) {
        this.transaction = transaction;
    }
}
