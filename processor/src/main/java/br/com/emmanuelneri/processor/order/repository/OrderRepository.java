package br.com.emmanuelneri.processor.order.repository;

import br.com.emmanuelneri.processor.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface OrderRepository extends JpaRepository<Order, Long> {

    @Query(name = "Order.findCompleteByIdentifier")
    Order findCompleteByIdentifier(@Param(value = "identifier") String identifier);

    boolean existsByIdentifier(@Param(value = "identifier") String identifier);

}

