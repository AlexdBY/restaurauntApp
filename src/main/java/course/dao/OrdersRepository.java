package course.dao;

import course.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alex on 13.12.2016.
 */
@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long> {
    List<Orders> findByMealName(String user);
    List<Orders> findByUser(String user);
}
