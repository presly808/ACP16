package dao;

import utils.ManagerCreator;

import javax.persistence.EntityManager;

public class QueryExecutor {

    public static void execute(DbAction o) {
        EntityManager entityManager = ManagerCreator.getManager();
        try{

            entityManager.getTransaction().begin();
            o.action(entityManager);
            entityManager.getTransaction().commit();

        } catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            entityManager.close();
        }
    }
}
