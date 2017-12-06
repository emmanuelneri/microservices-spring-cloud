package br.com.emmanuelneri.receiver.repository;

import br.com.emmanuelneri.receiver.model.Order;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
