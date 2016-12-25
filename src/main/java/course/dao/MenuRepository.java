package course.dao;

import course.domain.Menu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alex on 12.12.2016.
 */

@Repository
public interface MenuRepository extends JpaRepository<Menu, Long> {
    List<Menu> findByMealId (long mealId);
    List<Menu> findAll ();
    Menu findTop1ByMealName (String mealName);
}
