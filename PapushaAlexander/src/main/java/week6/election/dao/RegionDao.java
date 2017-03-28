package week6.election.dao;

import week6.election.model.Region;

/**
 * Created by alex on 22.03.17.
 */
public interface RegionDao extends Dao<Region, Integer>{

    Region findByName(String name);
}
