package week6.election.test;

import week6.election.model.Candidate;
import week6.election.model.Clan;
import week6.election.model.Region;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

/**
 * Created by alex on 04.03.17.
 */
public class Test {

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory =
                Persistence.createEntityManagerFactory("myunit");

        EntityManager manager = entityManagerFactory.createEntityManager();

        Clan clanGreen = new Clan("Green");
        Clan clanHit = new Clan("Hit");
        Clan clanBlue = new Clan("Blue");

        Region regionKiev = new Region("Kiev", 100000);
        Region regionPoltava = new Region("Poltava", 50000);
        Region regionOdessa = new Region("Odessa", 70000);

        Candidate candidate1 = new Candidate("candidate1", 45);
        Candidate candidate2 = new Candidate("candidate2", 50);
        Candidate candidate3 = new Candidate("candidate3", 43);
        Candidate candidate4 = new Candidate("candidate4", 44);
        Candidate candidate5 = new Candidate("candidate5", 42);

        clanGreen.getCandidateList().add(candidate1);
        clanGreen.getCandidateList().add(candidate4);
        clanBlue.getCandidateList().add(candidate3);
        clanBlue.getCandidateList().add(candidate5);
        clanHit.getCandidateList().add(candidate2);

        regionKiev.getCandidateList().add(candidate1);
        regionKiev.getCandidateList().add(candidate2);
        regionPoltava.getCandidateList().add(candidate3);
        regionOdessa.getCandidateList().add(candidate4);
        regionOdessa.getCandidateList().add(candidate5);

        candidate1.setClan(clanGreen);
        candidate2.setClan(clanHit);
        candidate3.setClan(clanBlue);
        candidate4.setClan(clanGreen);
        candidate5.setClan(clanBlue);

        candidate1.setRegion(regionKiev);
        candidate2.setRegion(regionKiev);
        candidate3.setRegion(regionPoltava);
        candidate4.setRegion(regionOdessa);
        candidate5.setRegion(regionOdessa);

        EntityTransaction transaction = manager.getTransaction();


            transaction.begin();

            manager.persist(candidate1);
            manager.persist(candidate2);
            manager.persist(candidate3);
            manager.persist(candidate4);
            manager.persist(candidate5);

            transaction.commit();

    }
}
