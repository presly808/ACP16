package week6.election.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import week6.election.model.Candidate;
import week6.election.model.Region;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CandidateDaoImp implements CandidateDao {

    @PersistenceContext
    private EntityManager entityManager;


    public CandidateDaoImp() {
    }

    @Override
    @Transactional
    public Candidate create(Candidate entity) {

        //EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.persist(entity);

        return entity;
    }

    @Override
    public List<Candidate> getAll(int offset, int length) {

        //EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("SELECT c FROM Candidate c").setFirstResult(offset)
                .setMaxResults(length).getResultList();
    }

    @Override
    public Candidate findOne(Integer integer) {

        //EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("SELECT c from Candidate c where c.id=:id", Candidate.class)
                .setParameter("id", integer).getSingleResult();
    }

    @Override
    @Transactional
    public Candidate delete(Integer integer) {

        //EntityManager entityManager = entityManagerFactory.createEntityManager();
        Candidate candidate = findOne(integer);

        entityManager.remove(candidate);

        return candidate;
    }

    @Override
    public List<Candidate> getByAge(int lowAge, int heightAge) {

        //EntityManager entityManager = entityManagerFactory.createEntityManager();

        return entityManager.createQuery("SELECT c FROM Candidate c WHERE age BETWEEN :min AND :max")
                .setParameter("min", lowAge).setParameter("max", heightAge).getResultList();
    }

    @Override
    public List<Candidate> getByRegion(Region region) {

        //EntityManager entityManager = entityManagerFactory.createEntityManager();

        //return entityManager.createQuery("SELECT c FROM Candidate c INNER JOIN Region r ON c.region=r.id WHERE r.name='Poltava'")

        return entityManager.createQuery("select c from Candidate c where c.region=:region")
                .setParameter("region", region).getResultList();
    }
}
