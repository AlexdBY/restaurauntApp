package course.dao;

import course.domain.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Alex on 12.12.2016.
 */
@Repository
public interface BasketRepository extends JpaRepository<Basket, Long>{
    List<Basket> findAll();
}
