package course.dao;


import course.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alex on 10.12.2016.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    User findById(long id);
    List<User> findAllByOrderById ();
    User findTop1ByName(String name);
    User findByName(String name);
}
