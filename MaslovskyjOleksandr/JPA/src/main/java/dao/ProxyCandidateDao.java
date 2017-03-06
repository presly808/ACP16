package dao;

import javax.persistence.EntityManager;

public interface ProxyCandidateDao extends DaoCandidate{

    void action(EntityManager manager);
}
