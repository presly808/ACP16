package week6.election.dao;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import week6.election.model.Region;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class RegionDaoImp implements RegionDao {

    @PersistenceContext
    private EntityManager entityManager;

    public RegionDaoImp() {
    }

    @Transactional
    @Override
    public Region create(Region entity) {
        return null;
    }

    @Override
    @Transactional
    public List<Region> getAll(int offset, int length) {
        return null;
    }

    @Override
    @Transactional
    public Region findOne(Integer integer) {
        return null;
    }

    @Override
    @Transactional
    public Region delete(Integer integer) {
        return null;
    }

    @Override
    @Transactional
    public Region findByName(String name) {

        return entityManager.createQuery("select r from Region r where r.name=:name", Region.class)
                .setParameter("name", name).getSingleResult();
    }

}
