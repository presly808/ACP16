package dao;

import javax.persistence.EntityManager;

@FunctionalInterface
public interface DbAction {

    void action(EntityManager entityManager);
}
