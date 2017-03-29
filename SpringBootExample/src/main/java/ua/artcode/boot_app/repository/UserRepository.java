package ua.artcode.boot_app.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.artcode.boot_app.model.User;

/**
 * @author Serhii Bilobrov
 * @since 1.7
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User findByName(String name);

    @Query(value = "SELECT u FROM User u WHERE u.name = :name")
    User searchByName(@Param("name") String name);

}
