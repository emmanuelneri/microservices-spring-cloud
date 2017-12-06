package br.com.emmanuelneri.processor.order.repository;

import br.com.emmanuelneri.processor.order.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order, Long> {
}
