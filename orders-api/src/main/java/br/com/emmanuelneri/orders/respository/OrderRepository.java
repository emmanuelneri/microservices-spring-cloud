package br.com.emmanuelneri.orders.respository;


import br.com.emmanuelneri.orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(value = "SELECT o FROM Order o JOIN FETCH o.customer")
    List<Order> findAllComplete();

    @Query(value = "SELECT o FROM Order o JOIN FETCH o.customer where o.id = :id")
    Order findOneComplete(@Param("id") Long id);
}

