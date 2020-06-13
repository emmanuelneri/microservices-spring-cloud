package br.com.emmanuelneri.orders.respository;


import br.com.emmanuelneri.orders.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface OrderRepository extends JpaRepository<Order, Long>, QuerydslPredicateExecutor<Long> {
}

