package br.com.emmanuelneri.orders.respository;


import br.com.emmanuelneri.orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}

